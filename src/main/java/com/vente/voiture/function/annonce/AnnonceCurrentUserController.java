package com.vente.voiture.function.annonce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vente.voiture.crud.service.AnnonceFavorisService;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.security.user.UsersService;
import com.vente.voiture.ws.structure.Response;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/annonce_current_user")
public class AnnonceCurrentUserController {
    @Autowired
    private AnnonceFavorisService annonce_favorisService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @GetMapping("/favoris")
    public Response getAllAnnonceFavoris(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            response.setDataOnSuccess(annonce_favorisService.getAnnonceFavorisByIdUsers(users.getId().intValue()));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }
    
}
