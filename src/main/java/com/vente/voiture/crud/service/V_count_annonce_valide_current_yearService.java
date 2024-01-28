package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_count_annonce_valide_current_year;
import com.vente.voiture.crud.repository.V_count_annonce_valide_current_yearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_count_annonce_valide_current_yearService {
    @Autowired
    private V_count_annonce_valide_current_yearRepository v_count_annonce_valide_current_yearRepository;

    // Read
    public List<V_count_annonce_valide_current_year> getAllV_count_annonce_valide_current_year() {
        return (List<V_count_annonce_valide_current_year>) v_count_annonce_valide_current_yearRepository.findAll();
    }

    // GetById
    public Optional<V_count_annonce_valide_current_year> getV_count_annonce_valide_current_yearById(Long id) {
        return v_count_annonce_valide_current_yearRepository.findById(id);
    }

    public List<V_count_annonce_valide_current_year> getV_count_annonce_valide_current_yearByNbAnnonceValide(Integer NbAnnonceValide) {
        return v_count_annonce_valide_current_yearRepository.findByNbAnnonceValide(NbAnnonceValide);
    }

    // Add your service methods here

}
