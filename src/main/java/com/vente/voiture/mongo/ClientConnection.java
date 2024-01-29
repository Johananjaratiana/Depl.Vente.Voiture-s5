package com.vente.voiture.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

public class ClientConnection{

    public static MongoClient GetMongoClient(){
        return MongoClients.create("mongodb://mongo:Edd1FdcEB6cg65eDC1fhAE1hG5h24bG2@monorail.proxy.rlwy.net:32982");
    }
}
