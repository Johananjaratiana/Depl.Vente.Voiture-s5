package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_user_ordered_by_commission;
import java.util.*;
import com.vente.voiture.crud.service.V_user_ordered_by_commissionService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_user_ordered_by_commissions")
public class V_user_ordered_by_commissionController {
    @Autowired
    private V_user_ordered_by_commissionService v_user_ordered_by_commissionService;

    @GetMapping
    public Response getAllV_user_ordered_by_commission() {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_user_ordered_by_commissionService.getAllV_user_ordered_by_commission());
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/pages")
    public Response getAllInPageV_user_ordered_by_commission( 
             @RequestParam(defaultValue = "0") int page, 
             @RequestParam(defaultValue = "10") int size) { 
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_user_ordered_by_commissionService.getAllV_user_ordered_by_commission(pageable));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/{id}")
    public Response getV_user_ordered_by_commissionById(@PathVariable Long id) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_user_ordered_by_commissionService.getV_user_ordered_by_commissionById(id));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }


    @GetMapping("idprofile/{idprofile}")
    public Response getV_user_ordered_by_commissionByIdprofile(@PathVariable Integer idprofile, 
             @RequestParam(defaultValue = "0") int page,
             @RequestParam(defaultValue = "10") int size) {
        Response response = new Response();
        try{
            Pageable pageable = PageRequest.of(page, size); 
             response.setDataOnSuccess(v_user_ordered_by_commissionService.getV_user_ordered_by_commissionByIdprofile(idprofile, pageable)); 
         }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
