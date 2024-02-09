package com.vente.voiture.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class ClientConnection{

    public static MongoClient GetMongoClient(){
        return MongoClients.create("mongodb://mongo:H6CAA5c2ahhCb2DbFEFBa2gAHbDCeHgF@monorail.proxy.rlwy.net:40448");
    }
}
