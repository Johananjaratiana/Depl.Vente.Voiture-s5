package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.AnnonceFavoris;
import com.vente.voiture.crud.service.AnnonceFavorisService;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
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

    @PostMapping
    public Response createAnnonceFavoris(@RequestBody AnnonceFavoris AnnonceFavoris, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(annonce_favorisService.save(AnnonceFavoris));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAllAnnonceFavoris() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonce_favorisService.getAllAnnonceFavoris());
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
    public Response getAnnonceFavorisByIdAnnonce(@PathVariable Integer id_annonce) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonce_favorisService.getAnnonceFavorisByIdAnnonce(id_annonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getAnnonceFavorisByIdUsers(@PathVariable Integer id_users) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonce_favorisService.getAnnonceFavorisByIdUsers(id_users));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
