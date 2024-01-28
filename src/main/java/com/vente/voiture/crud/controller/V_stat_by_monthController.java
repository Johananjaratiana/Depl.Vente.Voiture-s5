package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_stat_by_month;
import java.util.*;
import com.vente.voiture.crud.service.V_stat_by_monthService;
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
    public List<V_stat_by_month> getAllV_stat_by_month() {
        return v_stat_by_monthService.getAllV_stat_by_month();
    }

    @GetMapping("/{id}")
    public Optional<V_stat_by_month> getV_stat_by_monthById(@PathVariable Long id) {
        return v_stat_by_monthService.getV_stat_by_monthById(id);
    }


}
