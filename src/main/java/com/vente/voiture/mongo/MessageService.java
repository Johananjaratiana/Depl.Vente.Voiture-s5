package com.vente.voiture.mongo;

import java.sql.Connection;
import java.util.*;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;
import com.vente.voiture.crud.model.V_user_complet;
import com.vente.voiture.crud.service.PdpService;
import com.vente.voiture.crud.service.V_user_completService;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.services.DatabaseConnection;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageService {

    @Autowired
    V_user_completService v_user_completService;

    public Document GetMessageByTokenAndUser(Users users, Integer id_other_user)throws Exception
    {
        if(users.getId().intValue() == id_other_user.intValue())return null;
        try (MongoClient client = ClientConnection.GetMongoClient()) {
                MongoDatabase database = client.getDatabase("message_vente");
                MongoCollection<Document> collection = database.getCollection("messages");
                Document result = Message_2.GetOrCreateDocumentByTokenAndUser(collection, users.getId().intValue(), id_other_user, false);
                return result;
        } catch (MongoException e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    public Document GetNotSeenMessage(Users users)throws Exception{
        try(Connection connection = DatabaseConnection.GetConnection()){
            Document fromMongo = Message_2.GetNotSeenMessageFromMongo(users);
            Long id_other_user;
            // Parcourez chaque message dans not-seen-message
            for (Document message : (List<Document>) fromMongo.get("not-seen-message")) {
                Long senderId = Long.valueOf(message.get("sender_id").toString());
                Long receiverId = Long.valueOf(message.get("receiver_id").toString());
                if(users.getId().longValue() == senderId.longValue())  id_other_user = receiverId;
                else id_other_user = senderId;
                V_user_complet completedUsers = v_user_completService.getV_user_completById(id_other_user).get();
                Map<String, Object> completedMap = JsonParser.BuildJsonWithoutNullValue("other_user_", completedUsers);
                message.putAll(completedMap);
            }
            return fromMongo;
        }catch(Exception ex){
            ex.printStackTrace();
            throw new Exception(ex.getMessage());
        }
    }

    public String SaveMessageByTokenAndUser(Users users, ReceivedMessage receivedMessage){
        try (MongoClient client = ClientConnection.GetMongoClient()) {
            MongoDatabase database = client.getDatabase("message_vente");
            MongoCollection<Document> collection = database.getCollection("messages");
            Document new_sms = receivedMessage.BuildDocument(users);
            // Assuming you have the _id of the document you want to update
            Document document = Message_2.GetOrCreateDocumentByTokenAndUser(collection, users.getId().intValue(), receivedMessage.getId_other_user(), true); 
            // Use $push to add the new message to the sms array
            Bson filter = Filters.eq("_id", document.getObjectId("_id"));
            Bson update = Updates.push("sms", new_sms);
            UpdateResult result = collection.updateOne(filter, update);
            if (result.getModifiedCount() > 0) {
                return "Message added to sms array successfully";
            } else {
                return "Failed to add message to sms array";
            }
        } catch (MongoException e) {
            e.printStackTrace();
            return "Failed to send message";
        }
    }

    public Document SetViewMessage(Users users, Integer id_other_user)throws Exception{
        try (MongoClient client = ClientConnection.GetMongoClient()){
            MongoDatabase database = client.getDatabase("message_vente");
            MongoCollection<Document> collection = database.getCollection("messages");
            
            Bson filter = Filters.elemMatch("sms", Filters.eq("receiver_id", users.getId().intValue()));           
            Bson updates = Updates.combine(
                Updates.set("sms.$[elem].status", 10)
            );
            List<Bson> arrayFilters = Arrays.asList(Filters.eq("elem.receiver_id", users.getId().intValue()));
            UpdateOptions options = new UpdateOptions().arrayFilters(arrayFilters);
            
            UpdateResult result = collection.updateMany(filter, updates, options);
            if (result.getModifiedCount() > 0) {
                Document fromMongo = Message_2.GetOrCreateDocumentByTokenAndUser(collection, users.getId().intValue(), id_other_user, false); 
                return fromMongo;
            } else {
                throw new Exception("Pas de message non lue.");
            }
        }catch(MongoException me){
            me.printStackTrace();
            throw new Exception(me);
        }
    }
    
}
