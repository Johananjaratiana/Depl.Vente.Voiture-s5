package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_count_annonce_vendu_current_year;
import java.util.*;
import com.vente.voiture.crud.service.V_count_annonce_vendu_current_yearService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_count_annonce_vendu_current_years")
public class V_count_annonce_vendu_current_yearController {
    @Autowired
    private V_count_annonce_vendu_current_yearService v_count_annonce_vendu_current_yearService;

    @GetMapping
    public Response getAllV_count_annonce_vendu_current_year() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_count_annonce_vendu_current_yearService.getAllV_count_annonce_vendu_current_year());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_count_annonce_vendu_current_year( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_count_annonce_vendu_current_yearService.getAllV_count_annonce_vendu_current_year(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_count_annonce_vendu_current_yearById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_count_annonce_vendu_current_yearService.getV_count_annonce_vendu_current_yearById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


}
