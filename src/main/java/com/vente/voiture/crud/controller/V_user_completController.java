package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_user_complet;
import java.util.*;
import com.vente.voiture.crud.service.V_user_completService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_user_complets")
public class V_user_completController {
    @Autowired
    private V_user_completService v_user_completService;

    @GetMapping
    public Response getAllV_user_complet() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_user_completService.getAllV_user_complet());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_user_complet( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_user_completService.getAllV_user_complet(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_user_completById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_user_completService.getV_user_completById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("idprofile/{idprofile}")
    public Response getV_user_completByIdprofile(@PathVariable Integer idprofile, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_user_completService.getV_user_completByIdprofile(idprofile, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
