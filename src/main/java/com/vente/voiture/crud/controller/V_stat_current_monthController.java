package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_stat_current_month;
import java.util.*;
import com.vente.voiture.crud.service.V_stat_current_monthService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_stat_current_months")
public class V_stat_current_monthController {
    @Autowired
    private V_stat_current_monthService v_stat_current_monthService;

    @GetMapping
    public List<V_stat_current_month> getAllV_stat_current_month() {
        return v_stat_current_monthService.getAllV_stat_current_month();
    }

    @GetMapping("/{id}")
    public Optional<V_stat_current_month> getV_stat_current_monthById(@PathVariable Long id) {
        return v_stat_current_monthService.getV_stat_current_monthById(id);
    }


}
