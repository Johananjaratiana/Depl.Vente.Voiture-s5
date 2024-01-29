package com.vente.voiture.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class ClientConnection{

    public static MongoClient GetMongoClient(){
        return MongoClients.create("mongodb://localhost:27017");
    }
}
