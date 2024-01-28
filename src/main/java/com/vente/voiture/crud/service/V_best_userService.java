package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_best_user;
import com.vente.voiture.crud.repository.V_best_userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_best_userService {
    @Autowired
    private V_best_userRepository v_best_userRepository;

    // Read
    public List<V_best_user> getAllV_best_user() {
        return (List<V_best_user>) v_best_userRepository.findAll();
    }

    // GetById
    public Optional<V_best_user> getV_best_userById(Long id) {
        return v_best_userRepository.findById(id);
    }

    public List<V_best_user> getV_best_userByIdprofile(Integer Idprofile) {
        return v_best_userRepository.findByIdprofile(Idprofile);
    }

    // Add your service methods here

}
