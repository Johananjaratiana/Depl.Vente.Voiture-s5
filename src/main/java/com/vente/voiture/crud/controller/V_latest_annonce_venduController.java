package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_latest_annonce_vendu;
import java.util.*;
import com.vente.voiture.crud.service.V_latest_annonce_venduService;
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
    public List<V_latest_annonce_vendu> getAllV_latest_annonce_vendu() {
        return v_latest_annonce_venduService.getAllV_latest_annonce_vendu();
    }

    @GetMapping("/{id}")
    public Optional<V_latest_annonce_vendu> getV_latest_annonce_venduById(@PathVariable Long id) {
        return v_latest_annonce_venduService.getV_latest_annonce_venduById(id);
    }


    @GetMapping("type_moteur/{id_type_moteur}")
    public Response getV_latest_annonce_venduByIdTypeMoteur(@PathVariable Integer id_type_moteur) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdTypeMoteur(id_type_moteur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("taille/{id_taille}")
    public Response getV_latest_annonce_venduByIdTaille(@PathVariable Integer id_taille) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdTaille(id_taille));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("transmission/{id_transmission}")
    public Response getV_latest_annonce_venduByIdTransmission(@PathVariable Integer id_transmission) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdTransmission(id_transmission));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("couleur/{id_couleur}")
    public Response getV_latest_annonce_venduByIdCouleur(@PathVariable Integer id_couleur) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdCouleur(id_couleur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_annonce/{id_type_annonce}")
    public Response getV_latest_annonce_venduByIdTypeAnnonce(@PathVariable Integer id_type_annonce) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdTypeAnnonce(id_type_annonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("modele/{id_modele}")
    public Response getV_latest_annonce_venduByIdModele(@PathVariable Integer id_modele) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdModele(id_modele));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("marque/{id_marque}")
    public Response getV_latest_annonce_venduByIdMarque(@PathVariable Integer id_marque) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdMarque(id_marque));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getV_latest_annonce_venduByIdUsers(@PathVariable Integer id_users) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdUsers(id_users));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("energie/{id_energie}")
    public Response getV_latest_annonce_venduByIdEnergie(@PathVariable Integer id_energie) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdEnergie(id_energie));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("usage/{id_usage}")
    public Response getV_latest_annonce_venduByIdUsage(@PathVariable Integer id_usage) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_latest_annonce_venduService.getV_latest_annonce_venduByIdUsage(id_usage));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
