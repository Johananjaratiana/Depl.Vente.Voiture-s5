package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_annonce_complet;
import java.util.*;
import com.vente.voiture.crud.service.V_annonce_completService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;

import com.vente.voiture.ws.security.token.JwtTokenUtil;
import com.vente.voiture.ws.security.user.Users;
import com.vente.voiture.ws.security.user.UsersService;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_annonce_complets")
public class V_annonce_completController {

    @Autowired
    private V_annonce_completService v_annonce_completService;

    @Autowired
    private UsersService usersService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    
    @GetMapping
    public Response getAllV_annonce_complet() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getAllV_annonce_complet());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/current_users/favoris/pages")
    public Response getAnnonceFavorisByUsers(
            @RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader,
            @RequestParam(defaultValue = "0") int page, 
            @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
            Users users = jwtTokenUtil.validateTokenReturningUsers(usersService, authorizationHeader);
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completFavorisByUsersId(users.getId().intValue(), pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_annonce_complet( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getAllV_annonce_complet(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_annonce_completById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_completService.getV_annonce_completById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("modele/{id_modele}")
    public Response getV_annonce_completByIdModele(@PathVariable Integer id_modele, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdModele(id_modele, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("marque/{id_marque}")
    public Response getV_annonce_completByIdMarque(@PathVariable Integer id_marque, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdMarque(id_marque, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_moteur/{id_type_moteur}")
    public Response getV_annonce_completByIdTypeMoteur(@PathVariable Integer id_type_moteur, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdTypeMoteur(id_type_moteur, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("taille/{id_taille}")
    public Response getV_annonce_completByIdTaille(@PathVariable Integer id_taille, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdTaille(id_taille, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("users/{id_users}")
    public Response getV_annonce_completByIdUsers(@PathVariable Integer id_users, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdUsers(id_users, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("energie/{id_energie}")
    public Response getV_annonce_completByIdEnergie(@PathVariable Integer id_energie, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdEnergie(id_energie, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("transmission/{id_transmission}")
    public Response getV_annonce_completByIdTransmission(@PathVariable Integer id_transmission, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdTransmission(id_transmission, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("usage/{id_usage}")
    public Response getV_annonce_completByIdUsage(@PathVariable Integer id_usage, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdUsage(id_usage, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("couleur/{id_couleur}")
    public Response getV_annonce_completByIdCouleur(@PathVariable Integer id_couleur, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdCouleur(id_couleur, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("type_annonce/{id_type_annonce}")
    public Response getV_annonce_completByIdTypeAnnonce(@PathVariable Integer id_type_annonce, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_completService.getV_annonce_completByIdTypeAnnonce(id_type_annonce, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

        // ----------------------------- NEW FUNCTION
        @GetMapping("/non_valide")
        public Response getV_annonce_completNonValide( 
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size) {
            Response response = new Response();
            try{
                Pageable pageable = PageRequest.of(page, size); 
                response.setDataOnSuccess(v_annonce_completService.getV_annonce_completNonValide(pageable));
            }catch(Exception ex){
                response.setError(ex.getMessage());
            }
            return response;
        }
    
        @GetMapping("/non_vendu")
        public Response getV_annonce_completNonVendu( 
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size) {
            Response response = new Response();
            try{
                Pageable pageable = PageRequest.of(page, size); 
                response.setDataOnSuccess(v_annonce_completService.getV_annonce_completNonVendu(pageable));
            }catch(Exception ex){
                response.setError(ex.getMessage());
            }
            return response;
        }
    
        @GetMapping("/vendu")
        public Response getV_annonce_completVendu( 
                @RequestParam(defaultValue = "0") int page,
                @RequestParam(defaultValue = "10") int size) {
            Response response = new Response();
            try{
                Pageable pageable = PageRequest.of(page, size); 
                response.setDataOnSuccess(v_annonce_completService.getV_annonce_completVendu(pageable));
            }catch(Exception ex){
                response.setError(ex.getMessage());
            }
            return response;
        }

}
