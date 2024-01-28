package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_count_annonce_vendu_current_month;
import java.util.*;
import com.vente.voiture.crud.service.V_count_annonce_vendu_current_monthService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_count_annonce_vendu_current_months")
public class V_count_annonce_vendu_current_monthController {
    @Autowired
    private V_count_annonce_vendu_current_monthService v_count_annonce_vendu_current_monthService;

    @GetMapping
    public List<V_count_annonce_vendu_current_month> getAllV_count_annonce_vendu_current_month() {
        return v_count_annonce_vendu_current_monthService.getAllV_count_annonce_vendu_current_month();
    }

    @GetMapping("/{id}")
    public Optional<V_count_annonce_vendu_current_month> getV_count_annonce_vendu_current_monthById(@PathVariable Long id) {
        return v_count_annonce_vendu_current_monthService.getV_count_annonce_vendu_current_monthById(id);
    }


}
