package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_stat_by_month;
import java.util.*;
import com.vente.voiture.crud.service.V_stat_by_monthService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_stat_by_months")
public class V_stat_by_monthController {
    @Autowired
    private V_stat_by_monthService v_stat_by_monthService;

    @GetMapping
    public Response getAllV_stat_by_month() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_stat_by_monthService.getAllV_stat_by_month());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_stat_by_month( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_stat_by_monthService.getAllV_stat_by_month(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_stat_by_monthById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_stat_by_monthService.getV_stat_by_monthById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


}
