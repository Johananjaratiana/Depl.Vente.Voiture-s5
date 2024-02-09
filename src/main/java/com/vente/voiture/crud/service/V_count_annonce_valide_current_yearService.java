package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_count_annonce_valide_current_year;
import com.vente.voiture.crud.repository.V_count_annonce_valide_current_yearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class V_count_annonce_valide_current_yearService {
    @Autowired
    private V_count_annonce_valide_current_yearRepository v_count_annonce_valide_current_yearRepository;

    // Read
    public List<V_count_annonce_valide_current_year> getAllV_count_annonce_valide_current_year() {
        return v_count_annonce_valide_current_yearRepository.findAll();
    }

    // Read
    public Page<V_count_annonce_valide_current_year> getAllV_count_annonce_valide_current_year(Pageable pageable) {
        return v_count_annonce_valide_current_yearRepository.findAll(pageable);
    }

    // GetById
    public Optional<V_count_annonce_valide_current_year> getV_count_annonce_valide_current_yearById(Long id) {
        return v_count_annonce_valide_current_yearRepository.findById(id);
    }

    public Page<V_count_annonce_valide_current_year> getV_count_annonce_valide_current_yearByNbAnnonceValide(Integer NbAnnonceValide, Pageable pageable) {
        return v_count_annonce_valide_current_yearRepository.findByNbAnnonceValide(NbAnnonceValide, pageable);
    }

    // Add your service methods here

}
