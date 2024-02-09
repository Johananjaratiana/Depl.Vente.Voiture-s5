package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_landing_page;
import java.util.*;
import com.vente.voiture.crud.service.V_landing_pageService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_landing_pages")
public class V_landing_pageController {
    @Autowired
    private V_landing_pageService v_landing_pageService;

    @GetMapping
    public Response getAllV_landing_page() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_landing_pageService.getAllV_landing_page());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_landing_page( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_landing_pageService.getAllV_landing_page(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_landing_pageById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_landing_pageService.getV_landing_pageById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


}
