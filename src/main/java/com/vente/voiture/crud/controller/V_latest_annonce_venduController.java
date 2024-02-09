package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_latest_annonce_vendu;
import java.util.*;
import com.vente.voiture.crud.service.V_latest_annonce_venduService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_latest_annonce_vendus")
public class V_latest_annonce_venduController {
    @Autowired
    private V_latest_annonce_venduService v_latest_annonce_venduService;

    @GetMapping
    public Response getAllV_latest_annonce_vendu() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getAllV_latest_annonce_vendu());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_latest_annonce_vendu( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getAllV_latest_annonce_vendu(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_latest_annonce_venduById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("type_moteur/{id_type_moteur}")
    public Response getV_latest_annonce_venduByIdTypeMoteur(@PathVariable Integer id_type_moteur, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdTypeMoteur(id_type_moteur, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("taille/{id_taille}")
    public Response getV_latest_annonce_venduByIdTaille(@PathVariable Integer id_taille, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdTaille(id_taille, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("transmission/{id_transmission}")
    public Response getV_latest_annonce_venduByIdTransmission(@PathVariable Integer id_transmission, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdTransmission(id_transmission, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("couleur/{id_couleur}")
    public Response getV_latest_annonce_venduByIdCouleur(@PathVariable Integer id_couleur, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdCouleur(id_couleur, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_annonce/{id_type_annonce}")
    public Response getV_latest_annonce_venduByIdTypeAnnonce(@PathVariable Integer id_type_annonce, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdTypeAnnonce(id_type_annonce, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("modele/{id_modele}")
    public Response getV_latest_annonce_venduByIdModele(@PathVariable Integer id_modele, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdModele(id_modele, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("marque/{id_marque}")
    public Response getV_latest_annonce_venduByIdMarque(@PathVariable Integer id_marque, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdMarque(id_marque, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getV_latest_annonce_venduByIdUsers(@PathVariable Integer id_users, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdUsers(id_users, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("energie/{id_energie}")
    public Response getV_latest_annonce_venduByIdEnergie(@PathVariable Integer id_energie, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdEnergie(id_energie, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("usage/{id_usage}")
    public Response getV_latest_annonce_venduByIdUsage(@PathVariable Integer id_usage, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdUsage(id_usage, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
