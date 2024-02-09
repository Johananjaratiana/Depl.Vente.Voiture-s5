package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_annonce_complet_ordered_by_type_annonce;
import java.util.*;
import com.vente.voiture.crud.service.V_annonce_complet_ordered_by_type_annonceService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Response getAllV_annonce_complet_ordered_by_type_annonce() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getAllV_annonce_complet_ordered_by_type_annonce());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_annonce_complet_ordered_by_type_annonce( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getAllV_annonce_complet_ordered_by_type_annonce(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_annonce_complet_ordered_by_type_annonceById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("modele/{id_modele}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdModele(@PathVariable Integer id_modele, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdModele(id_modele, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("marque/{id_marque}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdMarque(@PathVariable Integer id_marque, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdMarque(id_marque, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_moteur/{id_type_moteur}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdTypeMoteur(@PathVariable Integer id_type_moteur, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdTypeMoteur(id_type_moteur, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("taille/{id_taille}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdTaille(@PathVariable Integer id_taille, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdTaille(id_taille, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdUsers(@PathVariable Integer id_users, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdUsers(id_users, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("energie/{id_energie}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdEnergie(@PathVariable Integer id_energie, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdEnergie(id_energie, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("transmission/{id_transmission}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdTransmission(@PathVariable Integer id_transmission, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdTransmission(id_transmission, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("usage/{id_usage}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdUsage(@PathVariable Integer id_usage, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdUsage(id_usage, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("couleur/{id_couleur}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdCouleur(@PathVariable Integer id_couleur, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdCouleur(id_couleur, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_annonce/{id_type_annonce}")
    public Response getV_annonce_complet_ordered_by_type_annonceByIdTypeAnnonce(@PathVariable Integer id_type_annonce, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_ordered_by_type_annonceService.getV_annonce_complet_ordered_by_type_annonceByIdTypeAnnonce(id_type_annonce, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
