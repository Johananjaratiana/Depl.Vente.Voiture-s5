package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.AnnonceFavoris;
import com.vente.voiture.crud.service.AnnonceFavorisService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.security.user.UsersService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/annonce_favoriss")
public class AnnonceFavorisController {
    @Autowired
    private AnnonceFavorisService annonce_favorisService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsersService usersService;

    @PostMapping
    public Response createAnnonceFavoris(@RequestBody AnnonceFavoris AnnonceFavoris, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
            AnnonceFavoris.setIdUsers(users.getId().intValue());
            response.setDataOnSuccess(annonce_favorisService.save(AnnonceFavoris));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAllannonce_favoris() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonce_favorisService.getAllannonce_favoris());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageannonce_favoris( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(annonce_favorisService.getAllAnnonceFavoris(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getAnnonceFavorisById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonce_favorisService.getAnnonceFavorisById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response updateAnnonceFavoris(@PathVariable Long id, @RequestBody AnnonceFavoris AnnonceFavorisDetails, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(annonce_favorisService.updateAnnonceFavoris(id, AnnonceFavorisDetails));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response deleteAnnonceFavoris(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            annonce_favorisService.deleteAnnonceFavoris(id);
            response.setDataOnSuccess("Success");
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("annonce/{id_annonce}")
    public Response getAnnonceFavorisByIdAnnonce(@PathVariable Integer id_annonce, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(annonce_favorisService.getAnnonceFavorisByIdAnnonce(id_annonce, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getAnnonceFavorisByIdUsers(@PathVariable Integer id_users, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(annonce_favorisService.getAnnonceFavorisByIdUsers(id_users, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
