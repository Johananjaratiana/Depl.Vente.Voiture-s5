package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_stat_by_month;
import com.vente.voiture.crud.repository.V_stat_by_monthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_stat_by_monthService {
    @Autowired
    private V_stat_by_monthRepository v_stat_by_monthRepository;

    // Read
    public List<V_stat_by_month> getAllV_stat_by_month() {
        return (List<V_stat_by_month>) v_stat_by_monthRepository.findAll();
    }

    // GetById
    public Optional<V_stat_by_month> getV_stat_by_monthById(Long id) {
        return v_stat_by_monthRepository.findById(id);
    }

    // Add your service methods here

}
