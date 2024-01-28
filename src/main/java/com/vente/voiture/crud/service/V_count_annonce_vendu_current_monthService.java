package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_count_annonce_vendu_current_month;
import com.vente.voiture.crud.repository.V_count_annonce_vendu_current_monthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_count_annonce_vendu_current_monthService {
    @Autowired
    private V_count_annonce_vendu_current_monthRepository v_count_annonce_vendu_current_monthRepository;

    // Read
    public List<V_count_annonce_vendu_current_month> getAllV_count_annonce_vendu_current_month() {
        return (List<V_count_annonce_vendu_current_month>) v_count_annonce_vendu_current_monthRepository.findAll();
    }

    // GetById
    public Optional<V_count_annonce_vendu_current_month> getV_count_annonce_vendu_current_monthById(Long id) {
        return v_count_annonce_vendu_current_monthRepository.findById(id);
    }

    // Add your service methods here

}
