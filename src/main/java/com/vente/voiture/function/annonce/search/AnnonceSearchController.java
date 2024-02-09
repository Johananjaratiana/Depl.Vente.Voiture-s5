package com.vente.voiture.function.annonce.search;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.vente.voiture.ws.services.DatabaseConnection;
import com.vente.voiture.ws.structure.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/annonce_search")
public class AnnonceSearchController {

    @Autowired
    private AnnonceCompletMaterializedService annonceCompletMaterializedService;

    @GetMapping("/marque_modele")
    public Response GetAllSearchedAnnonce(@RequestBody SearchSelection filterSelection) {
        Response response = new Response();
        try(Connection connection = DatabaseConnection.GetConnection()){
            response.setDataOnSuccess(filterSelection.GetAnnonceComplet(connection));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/full_text")
    public Response FullTextSearch(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestParam(defaultValue = "") String searchTerm
    ) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size);
            response.setDataOnSuccess(annonceCompletMaterializedService.search(searchTerm, pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }
    
}
