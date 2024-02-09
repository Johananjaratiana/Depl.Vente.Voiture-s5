package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_user_complet;
import com.vente.voiture.crud.repository.V_user_completRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class V_user_completService {
    @Autowired
    private V_user_completRepository v_user_completRepository;

    // Read
    public List<V_user_complet> getAllV_user_complet() {
        return v_user_completRepository.findAll();
    }

    // Read
    public Page<V_user_complet> getAllV_user_complet(Pageable pageable) {
        return v_user_completRepository.findAll(pageable);
    }

    // GetById
    public Optional<V_user_complet> getV_user_completById(Long id) {
        return v_user_completRepository.findById(id);
    }

    public Page<V_user_complet> getV_user_completByIdprofile(Integer Idprofile, Pageable pageable) {
        return v_user_completRepository.findByIdprofile(Idprofile, pageable);
    }

    // Add your service methods here

}
