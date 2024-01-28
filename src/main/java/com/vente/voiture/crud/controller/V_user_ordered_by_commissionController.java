package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_user_ordered_by_commission;
import java.util.*;
import com.vente.voiture.crud.service.V_user_ordered_by_commissionService;
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
    public List<V_user_ordered_by_commission> getAllV_user_ordered_by_commission() {
        return v_user_ordered_by_commissionService.getAllV_user_ordered_by_commission();
    }

    @GetMapping("/{id}")
    public Optional<V_user_ordered_by_commission> getV_user_ordered_by_commissionById(@PathVariable Long id) {
        return v_user_ordered_by_commissionService.getV_user_ordered_by_commissionById(id);
    }


    @GetMapping("idprofile/{idprofile}")
    public Response getV_user_ordered_by_commissionByIdprofile(@PathVariable Integer idprofile) {
        Response response = new Response();
        try{
            response.setDataOnSuccess(v_user_ordered_by_commissionService.getV_user_ordered_by_commissionByIdprofile(idprofile));
        }catch(Exception ex){
            response.setError(ex.getMessage());
        }
        return response;
    }

}
