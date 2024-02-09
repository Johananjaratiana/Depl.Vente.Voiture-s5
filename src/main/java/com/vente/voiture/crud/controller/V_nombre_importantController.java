package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_nombre_important;
import java.util.*;
import com.vente.voiture.crud.service.V_nombre_importantService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_nombre_importants")
public class V_nombre_importantController {
    @Autowired
    private V_nombre_importantService v_nombre_importantService;

    @GetMapping
    public Response getAllV_nombre_important() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_nombre_importantService.getAllV_nombre_important());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_nombre_important( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_nombre_importantService.getAllV_nombre_important(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_nombre_importantById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_nombre_importantService.getV_nombre_importantById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("nb_annonce_valide/{nb_annonce_valide}")
    public Response getV_nombre_importantByNbAnnonceValide(@PathVariable Integer nb_annonce_valide, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_nombre_importantService.getV_nombre_importantByNbAnnonceValide(nb_annonce_valide, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
