package com.vente.voiture.mongo;

import java.util.Date;

import org.bson.Document;

import com.vente.voiture.ws.security.user.Users;

public class ReceivedMessage {
    Integer id_other_user;
    String message;
    
    public Integer getId_other_user() {
        return id_other_user;
    }
    public void setId_other_user(Integer id_other_user) {
        this.id_other_user = id_other_user;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    public Document BuildDocument(Users users){
        Document messageDoc = new Document();
        messageDoc.append("sender_id", users.getId());
        messageDoc.append("receiver_id", this.getId_other_user());
        messageDoc.append("date_time", new Date());
        messageDoc.append("content", this.getMessage());
        messageDoc.append("status", 0);
        return messageDoc;
    }
}
