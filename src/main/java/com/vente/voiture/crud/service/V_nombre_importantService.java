package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_nombre_important;
import com.vente.voiture.crud.repository.V_nombre_importantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_nombre_importantService {
    @Autowired
    private V_nombre_importantRepository v_nombre_importantRepository;

    // Read
    public List<V_nombre_important> getAllV_nombre_important() {
        return (List<V_nombre_important>) v_nombre_importantRepository.findAll();
    }

    // GetById
    public Optional<V_nombre_important> getV_nombre_importantById(Long id) {
        return v_nombre_importantRepository.findById(id);
    }

    public List<V_nombre_important> getV_nombre_importantByNbAnnonceValide(Integer NbAnnonceValide) {
        return v_nombre_importantRepository.findByNbAnnonceValide(NbAnnonceValide);
    }

    // Add your service methods here

}
