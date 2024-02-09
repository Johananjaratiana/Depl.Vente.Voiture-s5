package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_user_ordered_by_commission;
import com.vente.voiture.crud.repository.V_user_ordered_by_commissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class V_user_ordered_by_commissionService {
    @Autowired
    private V_user_ordered_by_commissionRepository v_user_ordered_by_commissionRepository;

    // Read
    public List<V_user_ordered_by_commission> getAllV_user_ordered_by_commission() {
        return v_user_ordered_by_commissionRepository.findAll();
    }

    // Read
    public Page<V_user_ordered_by_commission> getAllV_user_ordered_by_commission(Pageable pageable) {
        return v_user_ordered_by_commissionRepository.findAll(pageable);
    }

    // GetById
    public Optional<V_user_ordered_by_commission> getV_user_ordered_by_commissionById(Long id) {
        return v_user_ordered_by_commissionRepository.findById(id);
    }

    public Page<V_user_ordered_by_commission> getV_user_ordered_by_commissionByIdprofile(Integer Idprofile, Pageable pageable) {
        return v_user_ordered_by_commissionRepository.findByIdprofile(Idprofile, pageable);
    }

    // Add your service methods here

}
