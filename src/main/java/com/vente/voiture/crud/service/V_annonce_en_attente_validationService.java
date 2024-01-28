package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_annonce_en_attente_validation;
import com.vente.voiture.crud.repository.V_annonce_en_attente_validationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_annonce_en_attente_validationService {
    @Autowired
    private V_annonce_en_attente_validationRepository v_annonce_en_attente_validationRepository;

    // Read
    public List<V_annonce_en_attente_validation> getAllV_annonce_en_attente_validation() {
        return (List<V_annonce_en_attente_validation>) v_annonce_en_attente_validationRepository.findAll();
    }

    // GetById
    public Optional<V_annonce_en_attente_validation> getV_annonce_en_attente_validationById(Long id) {
        return v_annonce_en_attente_validationRepository.findById(id);
    }

    // Add your service methods here

}
