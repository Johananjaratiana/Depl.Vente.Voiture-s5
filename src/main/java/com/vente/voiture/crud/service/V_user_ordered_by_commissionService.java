package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_user_ordered_by_commission;
import com.vente.voiture.crud.repository.V_user_ordered_by_commissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_user_ordered_by_commissionService {
    @Autowired
    private V_user_ordered_by_commissionRepository v_user_ordered_by_commissionRepository;

    // Read
    public List<V_user_ordered_by_commission> getAllV_user_ordered_by_commission() {
        return (List<V_user_ordered_by_commission>) v_user_ordered_by_commissionRepository.findAll();
    }

    // GetById
    public Optional<V_user_ordered_by_commission> getV_user_ordered_by_commissionById(Long id) {
        return v_user_ordered_by_commissionRepository.findById(id);
    }

    public List<V_user_ordered_by_commission> getV_user_ordered_by_commissionByIdprofile(Integer Idprofile) {
        return v_user_ordered_by_commissionRepository.findByIdprofile(Idprofile);
    }

    // Add your service methods here

}
