package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_best_user;
import java.util.*;
import com.vente.voiture.crud.service.V_best_userService;
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
    public List<V_best_user> getAllV_best_user() {
        return v_best_userService.getAllV_best_user();
    }

    @GetMapping("/{id}")
    public Optional<V_best_user> getV_best_userById(@PathVariable Long id) {
        return v_best_userService.getV_best_userById(id);
    }


    @GetMapping("idprofile/{idprofile}")
    public Response getV_best_userByIdprofile(@PathVariable Integer idprofile) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_best_userService.getV_best_userByIdprofile(idprofile));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
