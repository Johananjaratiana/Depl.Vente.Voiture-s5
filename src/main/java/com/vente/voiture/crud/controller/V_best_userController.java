package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_best_user;
import java.util.*;
import com.vente.voiture.crud.service.V_best_userService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_best_users")
public class V_best_userController {
    @Autowired
    private V_best_userService v_best_userService;

    @GetMapping
    public Response getAllV_best_user() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_best_userService.getAllV_best_user());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_best_user( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_best_userService.getAllV_best_user(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_best_userById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_best_userService.getV_best_userById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("idprofile/{idprofile}")
    public Response getV_best_userByIdprofile(@PathVariable Integer idprofile, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_best_userService.getV_best_userByIdprofile(idprofile, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
