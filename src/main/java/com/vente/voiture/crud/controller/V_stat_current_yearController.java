package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_stat_current_year;
import java.util.*;
import com.vente.voiture.crud.service.V_stat_current_yearService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_stat_current_years")
public class V_stat_current_yearController {
    @Autowired
    private V_stat_current_yearService v_stat_current_yearService;

    @GetMapping
    public List<V_stat_current_year> getAllV_stat_current_year() {
        return v_stat_current_yearService.getAllV_stat_current_year();
    }

    @GetMapping("/{id}")
    public Optional<V_stat_current_year> getV_stat_current_yearById(@PathVariable Long id) {
        return v_stat_current_yearService.getV_stat_current_yearById(id);
    }


}
