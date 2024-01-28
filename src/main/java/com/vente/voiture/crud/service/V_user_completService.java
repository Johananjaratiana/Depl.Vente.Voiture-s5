package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_user_complet;
import com.vente.voiture.crud.repository.V_user_completRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_user_completService {
    @Autowired
    private V_user_completRepository v_user_completRepository;

    // Read
    public List<V_user_complet> getAllV_user_complet() {
        return (List<V_user_complet>) v_user_completRepository.findAll();
    }

    // GetById
    public Optional<V_user_complet> getV_user_completById(Long id) {
        return v_user_completRepository.findById(id);
    }

    public List<V_user_complet> getV_user_completByIdprofile(Integer Idprofile) {
        return v_user_completRepository.findByIdprofile(Idprofile);
    }

    // Add your service methods here

}
