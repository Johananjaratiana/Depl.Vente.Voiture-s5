package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_nombre_important;
import java.util.*;
import com.vente.voiture.crud.service.V_nombre_importantService;
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
    public List<V_nombre_important> getAllV_nombre_important() {
        return v_nombre_importantService.getAllV_nombre_important();
    }

    @GetMapping("/{id}")
    public Optional<V_nombre_important> getV_nombre_importantById(@PathVariable Long id) {
        return v_nombre_importantService.getV_nombre_importantById(id);
    }


    @GetMapping("nb_annonce_valide/{nb_annonce_valide}")
    public Response getV_nombre_importantByNbAnnonceValide(@PathVariable Integer nb_annonce_valide) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_nombre_importantService.getV_nombre_importantByNbAnnonceValide(nb_annonce_valide));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
