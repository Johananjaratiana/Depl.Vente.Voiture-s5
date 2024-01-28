package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.EtatAnnonce;
import com.vente.voiture.crud.service.EtatAnnonceService;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/etat_annonces")
public class EtatAnnonceController {
    @Autowired
    private EtatAnnonceService etat_annonceService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public Response createEtatAnnonce(@RequestBody EtatAnnonce EtatAnnonce, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(etat_annonceService.save(EtatAnnonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAllEtatAnnonce() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(etat_annonceService.getAllEtatAnnonce());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getEtatAnnonceById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(etat_annonceService.getEtatAnnonceById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response updateEtatAnnonce(@PathVariable Long id, @RequestBody EtatAnnonce EtatAnnonceDetails, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(etat_annonceService.updateEtatAnnonce(id, EtatAnnonceDetails));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response deleteEtatAnnonce(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            etat_annonceService.deleteEtatAnnonce(id);
            response.setDataOnSuccess("Success");
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("annonce/{id_annonce}")
    public Response getEtatAnnonceByIdAnnonce(@PathVariable Integer id_annonce) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(etat_annonceService.getEtatAnnonceByIdAnnonce(id_annonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
