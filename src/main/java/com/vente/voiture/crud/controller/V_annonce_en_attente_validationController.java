package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_annonce_en_attente_validation;
import java.util.*;
import com.vente.voiture.crud.service.V_annonce_en_attente_validationService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_annonce_en_attente_validations")
public class V_annonce_en_attente_validationController {
    @Autowired
    private V_annonce_en_attente_validationService v_annonce_en_attente_validationService;

    @GetMapping
    public Response getAllV_annonce_en_attente_validation() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_en_attente_validationService.getAllV_annonce_en_attente_validation());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_annonce_en_attente_validation( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_annonce_en_attente_validationService.getAllV_annonce_en_attente_validation(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_annonce_en_attente_validationById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_annonce_en_attente_validationService.getV_annonce_en_attente_validationById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


}
