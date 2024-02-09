package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_nombre_important;
import com.vente.voiture.crud.repository.V_nombre_importantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class V_nombre_importantService {
    @Autowired
    private V_nombre_importantRepository v_nombre_importantRepository;

    // Read
    public List<V_nombre_important> getAllV_nombre_important() {
        return v_nombre_importantRepository.findAll();
    }

    // Read
    public Page<V_nombre_important> getAllV_nombre_important(Pageable pageable) {
        return v_nombre_importantRepository.findAll(pageable);
    }

    // GetById
    public Optional<V_nombre_important> getV_nombre_importantById(Long id) {
        return v_nombre_importantRepository.findById(id);
    }

    public Page<V_nombre_important> getV_nombre_importantByNbAnnonceValide(Integer NbAnnonceValide, Pageable pageable) {
        return v_nombre_importantRepository.findByNbAnnonceValide(NbAnnonceValide, pageable);
    }

    // Add your service methods here

}
