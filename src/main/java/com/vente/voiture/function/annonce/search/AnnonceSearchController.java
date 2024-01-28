package com.vente.voiture.function.annonce.search;

import java.sql.Connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.vente.voiture.ws.security.token.JwtTokenUtil;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.security.user.UsersService;
import com.vente.voiture.ws.services.DatabaseConnection;
import com.vente.voiture.ws.structure.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/annonce_search")
public class AnnonceSearchController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/marque_modele")
    public Response GetAllSearchedAnnonce(@RequestBody SearchSelection filterSelection, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try(Connection connection = DatabaseConnection.GetConnection()){
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            response.setDataOnSuccess(filterSelection.GetAnnonceComplet(users, connection));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }
    
}
