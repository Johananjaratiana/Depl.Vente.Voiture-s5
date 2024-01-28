package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_annonce_vendu_current_month;
import java.util.*;
import com.vente.voiture.crud.service.V_annonce_vendu_current_monthService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_annonce_vendu_current_months")
public class V_annonce_vendu_current_monthController {
    @Autowired
    private V_annonce_vendu_current_monthService v_annonce_vendu_current_monthService;

    @GetMapping
    public List<V_annonce_vendu_current_month> getAllV_annonce_vendu_current_month() {
        return v_annonce_vendu_current_monthService.getAllV_annonce_vendu_current_month();
    }

    @GetMapping("/{id}")
    public Optional<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthById(@PathVariable Long id) {
        return v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthById(id);
    }


    @GetMapping("type_moteur/{id_type_moteur}")
    public Response getV_annonce_vendu_current_monthByIdTypeMoteur(@PathVariable Integer id_type_moteur) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthByIdTypeMoteur(id_type_moteur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("taille/{id_taille}")
    public Response getV_annonce_vendu_current_monthByIdTaille(@PathVariable Integer id_taille) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthByIdTaille(id_taille));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("transmission/{id_transmission}")
    public Response getV_annonce_vendu_current_monthByIdTransmission(@PathVariable Integer id_transmission) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthByIdTransmission(id_transmission));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("couleur/{id_couleur}")
    public Response getV_annonce_vendu_current_monthByIdCouleur(@PathVariable Integer id_couleur) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthByIdCouleur(id_couleur));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_annonce/{id_type_annonce}")
    public Response getV_annonce_vendu_current_monthByIdTypeAnnonce(@PathVariable Integer id_type_annonce) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthByIdTypeAnnonce(id_type_annonce));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("modele/{id_modele}")
    public Response getV_annonce_vendu_current_monthByIdModele(@PathVariable Integer id_modele) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthByIdModele(id_modele));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("marque/{id_marque}")
    public Response getV_annonce_vendu_current_monthByIdMarque(@PathVariable Integer id_marque) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthByIdMarque(id_marque));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getV_annonce_vendu_current_monthByIdUsers(@PathVariable Integer id_users) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthByIdUsers(id_users));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("energie/{id_energie}")
    public Response getV_annonce_vendu_current_monthByIdEnergie(@PathVariable Integer id_energie) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthByIdEnergie(id_energie));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("usage/{id_usage}")
    public Response getV_annonce_vendu_current_monthByIdUsage(@PathVariable Integer id_usage) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_vendu_current_monthService.getV_annonce_vendu_current_monthByIdUsage(id_usage));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
