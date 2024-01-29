package com.vente.voiture.function.annonce.filtre;

import java.sql.Connection;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.vente.voiture.ws.services.DatabaseConnection;
import com.vente.voiture.ws.structure.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/annonce_filter")
public class AnnonceFilterController {

    @PostMapping
    public Response GetAllFilteredAnnonce(@RequestBody FilterSelection filterSelection) {
        Response response = new Response();
        try(Connection connection = DatabaseConnection.GetConnection()){
            response.setDataOnSuccess(filterSelection.GetAnnonceComplet(connection));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }
}