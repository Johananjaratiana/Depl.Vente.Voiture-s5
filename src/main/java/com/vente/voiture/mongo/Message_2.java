package com.vente.voiture.mongo;

import java.util.*;
import java.util.function.Consumer;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoException;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.vente.voiture.ws.security.user.Users;

public class Message_2 {

    public static Document GetNotSeenMessageFromMongo(Users users)
    {
        Document result = new Document();
        List<Object> not_seen_message = new ArrayList<>();

        try (MongoClient client = ClientConnection.GetMongoClient()) {
            MongoDatabase database = client.getDatabase("message_vente");
            MongoCollection<Document> collection = database.getCollection("messages");
            Consumer<Document> processBlock = new Consumer<Document>() {
                @Override
                public void accept(Document document) {
                    not_seen_message.add(document.get("sms"));
                    System.out.println(document);
                }
            };
            List<? extends Bson> pipeline = Arrays.asList(
                    new Document()
                            .append("$match", new Document()
                                    .append("identifiant", new Document()
                                            .append("$elemMatch", new Document()
                                                    .append("$eq", users.getId())
                                            )
                                    )
                            ), 
                    new Document()
                            .append("$unwind", "$sms"), 
                    new Document()
                            .append("$match", new Document()
                                    .append("sms.status", 0.0)
                            )
            );
            collection.aggregate(pipeline).forEach(processBlock);

            result.append("not-seen-message", not_seen_message);
        } catch (MongoException e) {
            e.printStackTrace();
        }
        return result;
    } 
    

    public static Document GetOrCreateDocumentByTokenAndUser(MongoCollection<Document> collection, Integer users_id, Integer other_user_id, Boolean canCreate) {
        List<Integer> identifiant = Arrays.asList(users_id, other_user_id);
        Bson filter = Filters.all("identifiant", identifiant);
        FindIterable<Document> documents = collection.find(filter);

        Document document;

        if (!documents.iterator().hasNext()) {
            if(canCreate == true){
                document = new Document("identifiant", identifiant).append("sms", new ArrayList<>());
                collection.insertOne(document);
            }
            else{
                document = new Document();
            }
        } else {
            document = documents.first();
        }

        return document;
    }
}
