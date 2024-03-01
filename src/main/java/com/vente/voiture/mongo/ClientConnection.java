package com.vente.voiture.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class ClientConnection{

    public static MongoClient GetMongoClient(){
        return MongoClients.create("mongodb://mongo:b11bbcb1cBa3AEC45cce2aCbD-e1dcAf@viaduct.proxy.rlwy.net:35157");
    }
}
