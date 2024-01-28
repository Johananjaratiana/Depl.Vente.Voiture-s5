package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_annonce_complet;
import java.util.*;
import com.vente.voiture.crud.service.V_annonce_completService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_annonce_complets")
public class V_annonce_completController {
    @Autowired
    private V_annonce_completService v_annonce_completService;

    @GetMapping
    public List<V_annonce_complet> getAllV_annonce_complet() {
        return v_annonce_completService.getAllV_annonce_complet();
    }

    @GetMapping("/{id}")
    public Optional<V_annonce_complet> getV_annonce_completById(@PathVariable Long id) {
        return v_annonce_completService.getV_annonce_completById(id);
    }


    @GetMapping("modele/{id_modele}")
    public Response getV_annonce_completByIdModele(@PathVariable Integer id_modele) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdModele(id_modele));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("marque/{id_marque}")
    public Response getV_annonce_completByIdMarque(@PathVariable Integer id_marque) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdMarque(id_marque));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_moteur/{id_type_moteur}")
    public Response getV_annonce_completByIdTypeMoteur(@PathVariable Integer id_type_moteur) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdTypeMoteur(id_type_moteur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("taille/{id_taille}")
    public Response getV_annonce_completByIdTaille(@PathVariable Integer id_taille) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdTaille(id_taille));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getV_annonce_completByIdUsers(@PathVariable Integer id_users) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdUsers(id_users));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("energie/{id_energie}")
    public Response getV_annonce_completByIdEnergie(@PathVariable Integer id_energie) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdEnergie(id_energie));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("transmission/{id_transmission}")
    public Response getV_annonce_completByIdTransmission(@PathVariable Integer id_transmission) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdTransmission(id_transmission));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("usage/{id_usage}")
    public Response getV_annonce_completByIdUsage(@PathVariable Integer id_usage) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdUsage(id_usage));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("couleur/{id_couleur}")
    public Response getV_annonce_completByIdCouleur(@PathVariable Integer id_couleur) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdCouleur(id_couleur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_annonce/{id_type_annonce}")
    public Response getV_annonce_completByIdTypeAnnonce(@PathVariable Integer id_type_annonce) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdTypeAnnonce(id_type_annonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
