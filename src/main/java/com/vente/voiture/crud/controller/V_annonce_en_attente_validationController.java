package com.vente.voiture.crud.controller;

import com.vente.voiture.crud.model.V_annonce_en_attente_validation;
import java.util.*;
import com.vente.voiture.crud.service.V_annonce_en_attente_validationService;
import org.springframework.beans.factory.annotation.Autowired;
import com.vente.voiture.ws.structure.Response;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/v_annonce_en_attente_validations")
public class V_annonce_en_attente_validationController {
    @Autowired
    private V_annonce_en_attente_validationService v_annonce_en_attente_validationService;

    @GetMapping
    public List<V_annonce_en_attente_validation> getAllV_annonce_en_attente_validation() {
        return v_annonce_en_attente_validationService.getAllV_annonce_en_attente_validation();
    }

    @GetMapping("/{id}")
    public Optional<V_annonce_en_attente_validation> getV_annonce_en_attente_validationById(@PathVariable Long id) {
        return v_annonce_en_attente_validationService.getV_annonce_en_attente_validationById(id);
    }


}
