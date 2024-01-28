package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.Annonce;
import com.vente.voiture.crud.service.AnnonceService;
import com.vente.voiture.ws.structure.Response;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.security.token.JwtTokenUtil;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpHeaders;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/annonces")
public class AnnonceController {
    @Autowired
    private AnnonceService annonceService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @PostMapping
    public Response createAnnonce(@RequestBody Annonce Annonce, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(annonceService.save(Annonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping
    public Response getAllAnnonce() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAllAnnonce());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getAnnonceById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @PutMapping("/{id}")
    public Response updateAnnonce(@PathVariable Long id, @RequestBody Annonce AnnonceDetails, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            response.setDataOnSuccess(annonceService.updateAnnonce(id, AnnonceDetails));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @DeleteMapping("/{id}")
    public Response deleteAnnonce(@PathVariable Long id, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        Response response = new Response();
        try{
            jwtTokenUtil.validateToken(authorizationHeader);
            annonceService.deleteAnnonce(id);
            response.setDataOnSuccess("Success");
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("modele/{id_modele}")
    public Response getAnnonceByIdModele(@PathVariable Integer id_modele) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceByIdModele(id_modele));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("marque/{id_marque}")
    public Response getAnnonceByIdMarque(@PathVariable Integer id_marque) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceByIdMarque(id_marque));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_moteur/{id_type_moteur}")
    public Response getAnnonceByIdTypeMoteur(@PathVariable Integer id_type_moteur) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceByIdTypeMoteur(id_type_moteur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getAnnonceByIdUsers(@PathVariable Integer id_users) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceByIdUsers(id_users));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("energie/{id_energie}")
    public Response getAnnonceByIdEnergie(@PathVariable Integer id_energie) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceByIdEnergie(id_energie));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("transmission/{id_transmission}")
    public Response getAnnonceByIdTransmission(@PathVariable Integer id_transmission) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceByIdTransmission(id_transmission));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("usage/{id_usage}")
    public Response getAnnonceByIdUsage(@PathVariable Integer id_usage) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceByIdUsage(id_usage));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("couleur/{id_couleur}")
    public Response getAnnonceByIdCouleur(@PathVariable Integer id_couleur) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceByIdCouleur(id_couleur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("taille/{id_taille}")
    public Response getAnnonceByIdTaille(@PathVariable Integer id_taille) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceByIdTaille(id_taille));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_annonce/{id_type_annonce}")
    public Response getAnnonceByIdTypeAnnonce(@PathVariable Integer id_type_annonce) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(annonceService.getAnnonceByIdTypeAnnonce(id_type_annonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
