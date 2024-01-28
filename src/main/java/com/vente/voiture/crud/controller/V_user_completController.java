package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_user_complet;
import java.util.*;
import com.vente.voiture.crud.service.V_user_completService;
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
    public List<V_user_complet> getAllV_user_complet() {
        return v_user_completService.getAllV_user_complet();
    }

    @GetMapping("/{id}")
    public Optional<V_user_complet> getV_user_completById(@PathVariable Long id) {
        return v_user_completService.getV_user_completById(id);
    }


    @GetMapping("idprofile/{idprofile}")
    public Response getV_user_completByIdprofile(@PathVariable Integer idprofile) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_user_completService.getV_user_completByIdprofile(idprofile));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
