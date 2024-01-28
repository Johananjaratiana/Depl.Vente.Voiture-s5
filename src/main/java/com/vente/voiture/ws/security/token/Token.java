package com.vente.voiture.ws.security.token;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Connection;
import java.util.Date;
import com.vente.voiture.ws.services.DatabaseConnection;

public class Token {
    String token;
    Boolean isWorking;

    public Token(String token, Boolean isWorking) {
        this.token = token;
        this.isWorking = isWorking;
    }

    public static void saveToken(int userId, String token, Date expirationDate) throws Exception {
        try (Connection connection = DatabaseConnection.GetConnection()) {
            String query = "INSERT INTO token (idusers, token, dtexp) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setString(2, token);
            preparedStatement.setDate(3, new java.sql.Date(expirationDate.getTime()));
            preparedStatement.executeUpdate();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static boolean isTokenValid(String token) throws Exception {
        try (Connection connection = DatabaseConnection.GetConnection()) {
            String query = "SELECT COUNT(*) FROM token WHERE token = ? AND dtexp >= CURRENT_DATE AND isvalidate::boolean = true";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, token);
            // System.out.println("------------------------------------");
            // System.out.println(preparedStatement.toString());
            // System.out.println("------------------------------------");
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) > 0;
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public static void invalidateToken(int userId) throws Exception{
        try(Connection connection = DatabaseConnection.GetConnection()){
            String query = "UPDATE token SET isvalidate = 0 WHERE idusers = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeUpdate();
        }catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(Boolean isWorking) {
        this.isWorking = isWorking;
    }
}
