package com.vente.voiture.function.annonce.filtre;

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
@RequestMapping("/api/annonce_filter")
public class AnnonceFilterController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping
    public Response GetAllFilteredAnnonce(@RequestBody FilterSelection filterSelection, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
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
