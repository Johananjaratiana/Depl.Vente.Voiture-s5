package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.ProfilUtilisateur;
import com.vente.voiture.crud.service.ProfilUtilisateurService;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/profil_utilisateurs")
public class ProfilUtilisateurController {
    @Autowired
    private ProfilUtilisateurService profil_utilisateurService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public Response createProfilUtilisateur(@RequestBody ProfilUtilisateur ProfilUtilisateur, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(profil_utilisateurService.save(ProfilUtilisateur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAllProfilUtilisateur() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(profil_utilisateurService.getAllProfilUtilisateur());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getProfilUtilisateurById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(profil_utilisateurService.getProfilUtilisateurById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response updateProfilUtilisateur(@PathVariable Long id, @RequestBody ProfilUtilisateur ProfilUtilisateurDetails, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(profil_utilisateurService.updateProfilUtilisateur(id, ProfilUtilisateurDetails));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response deleteProfilUtilisateur(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            profil_utilisateurService.deleteProfilUtilisateur(id);
            response.setDataOnSuccess("Success");
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


}
