package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_stat_current_month;
import com.vente.voiture.crud.repository.V_stat_current_monthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class V_stat_current_monthService {
    @Autowired
    private V_stat_current_monthRepository v_stat_current_monthRepository;

    // Read
    public List<V_stat_current_month> getAllV_stat_current_month() {
        return v_stat_current_monthRepository.findAll();
    }

    // Read
    public Page<V_stat_current_month> getAllV_stat_current_month(Pageable pageable) {
        return v_stat_current_monthRepository.findAll(pageable);
    }

    // GetById
    public Optional<V_stat_current_month> getV_stat_current_monthById(Long id) {
        return v_stat_current_monthRepository.findById(id);
    }

    // Add your service methods here

}
