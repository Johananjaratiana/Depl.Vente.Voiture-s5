package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_annonce_complet_current_month;
import java.util.*;
import com.vente.voiture.crud.service.V_annonce_complet_current_monthService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_annonce_complet_current_months")
public class V_annonce_complet_current_monthController {
    @Autowired
    private V_annonce_complet_current_monthService v_annonce_complet_current_monthService;

    @GetMapping
    public Response getAllV_annonce_complet_current_month() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_current_monthService.getAllV_annonce_complet_current_month());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_annonce_complet_current_month( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getAllV_annonce_complet_current_month(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_annonce_complet_current_monthById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("modele/{id_modele}")
    public Response getV_annonce_complet_current_monthByIdModele(@PathVariable Integer id_modele, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthByIdModele(id_modele, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("marque/{id_marque}")
    public Response getV_annonce_complet_current_monthByIdMarque(@PathVariable Integer id_marque, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthByIdMarque(id_marque, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_moteur/{id_type_moteur}")
    public Response getV_annonce_complet_current_monthByIdTypeMoteur(@PathVariable Integer id_type_moteur, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthByIdTypeMoteur(id_type_moteur, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("taille/{id_taille}")
    public Response getV_annonce_complet_current_monthByIdTaille(@PathVariable Integer id_taille, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthByIdTaille(id_taille, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getV_annonce_complet_current_monthByIdUsers(@PathVariable Integer id_users, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthByIdUsers(id_users, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("energie/{id_energie}")
    public Response getV_annonce_complet_current_monthByIdEnergie(@PathVariable Integer id_energie, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthByIdEnergie(id_energie, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("transmission/{id_transmission}")
    public Response getV_annonce_complet_current_monthByIdTransmission(@PathVariable Integer id_transmission, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthByIdTransmission(id_transmission, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("usage/{id_usage}")
    public Response getV_annonce_complet_current_monthByIdUsage(@PathVariable Integer id_usage, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthByIdUsage(id_usage, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("couleur/{id_couleur}")
    public Response getV_annonce_complet_current_monthByIdCouleur(@PathVariable Integer id_couleur, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthByIdCouleur(id_couleur, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_annonce/{id_type_annonce}")
    public Response getV_annonce_complet_current_monthByIdTypeAnnonce(@PathVariable Integer id_type_annonce, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_complet_current_monthService.getV_annonce_complet_current_monthByIdTypeAnnonce(id_type_annonce, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
