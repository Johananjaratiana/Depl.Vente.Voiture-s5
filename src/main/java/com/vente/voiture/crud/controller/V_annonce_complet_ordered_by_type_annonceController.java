package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_annonce_complet_ordered_by_type_annonce;
import java.util.*;
import com.vente.voiture.crud.service.V_annonce_complet_ordered_by_type_annonceService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_annonce_complet_ordered_by_type_annonces")
public class V_annonce_complet_ordered_by_type_annonceController {
    @Autowired
    private V_annonce_complet_ordered_by_type_annonceService v_annonce_complet_ordered_by_type_annonceService;

    @GetMapping
    public List<V_annonce_complet_ordered_by_type_annonce> getAllV_annonce_complet_ordered_by_type_annonce() {
        return v_annonce_complet_ordered_by_type_annonceService.getAllV_annonce_complet_ordered_by_type_annonce();
    }

    @GetMapping("/{id}")
    public Optional<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceById(@PathVariable Long id) {
        return v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceById(id);
    }


    @GetMapping("modele/{id_modele}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdModele(@PathVariable Integer id_modele) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdModele(id_modele));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("marque/{id_marque}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdMarque(@PathVariable Integer id_marque) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdMarque(id_marque));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_moteur/{id_type_moteur}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdTypeMoteur(@PathVariable Integer id_type_moteur) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdTypeMoteur(id_type_moteur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("taille/{id_taille}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdTaille(@PathVariable Integer id_taille) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdTaille(id_taille));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdUsers(@PathVariable Integer id_users) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdUsers(id_users));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("energie/{id_energie}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdEnergie(@PathVariable Integer id_energie) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdEnergie(id_energie));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("transmission/{id_transmission}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdTransmission(@PathVariable Integer id_transmission) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdTransmission(id_transmission));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("usage/{id_usage}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdUsage(@PathVariable Integer id_usage) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdUsage(id_usage));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("couleur/{id_couleur}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdCouleur(@PathVariable Integer id_couleur) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdCouleur(id_couleur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_annonce/{id_type_annonce}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdTypeAnnonce(@PathVariable Integer id_type_annonce) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdTypeAnnonce(id_type_annonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
