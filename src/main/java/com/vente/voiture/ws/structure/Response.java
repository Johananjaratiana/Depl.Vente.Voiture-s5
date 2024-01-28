package com.vente.voiture.ws.structure;

public class Response {
    String message;
    Object data;


    
    public Response() {
    }
    public Response(String message, Object data) {
        this.message = message;
        this.data = data;
    }
    public void setDataOnSuccess(Object data){
        this.setMessage("success");
        this.setData(data);
    }

    public void setError(String data){
        this.setMessage("error");
        this.setData(data);
    }
    public String getMessage() {
        return message;
    }
    private void setMessage(String message) {
        this.message = message;
    }
    public Object getData() {
        return data;
    }
    private void setData(Object data) {
        this.data = data;
    }

    
}

