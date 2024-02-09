package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_annonce_complet_current_month;
import com.vente.voiture.crud.repository.V_annonce_complet_current_monthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class V_annonce_complet_current_monthService {
    @Autowired
    private V_annonce_complet_current_monthRepository v_annonce_complet_current_monthRepository;

    // Read
    public List<V_annonce_complet_current_month> getAllV_annonce_complet_current_month() {
        return v_annonce_complet_current_monthRepository.findAll();
    }

    // Read
    public Page<V_annonce_complet_current_month> getAllV_annonce_complet_current_month(Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findAll(pageable);
    }

    // GetById
    public Optional<V_annonce_complet_current_month> getV_annonce_complet_current_monthById(Long id) {
        return v_annonce_complet_current_monthRepository.findById(id);
    }

    public Page<V_annonce_complet_current_month> getV_annonce_complet_current_monthByIdModele(Integer IdModele, Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findByIdModele(IdModele, pageable);
    }

    public Page<V_annonce_complet_current_month> getV_annonce_complet_current_monthByIdMarque(Integer IdMarque, Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findByIdMarque(IdMarque, pageable);
    }

    public Page<V_annonce_complet_current_month> getV_annonce_complet_current_monthByIdTypeMoteur(Integer IdTypeMoteur, Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findByIdTypeMoteur(IdTypeMoteur, pageable);
    }

    public Page<V_annonce_complet_current_month> getV_annonce_complet_current_monthByIdTaille(Integer IdTaille, Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findByIdTaille(IdTaille, pageable);
    }

    public Page<V_annonce_complet_current_month> getV_annonce_complet_current_monthByIdUsers(Integer IdUsers, Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findByIdUsers(IdUsers, pageable);
    }

    public Page<V_annonce_complet_current_month> getV_annonce_complet_current_monthByIdEnergie(Integer IdEnergie, Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findByIdEnergie(IdEnergie, pageable);
    }

    public Page<V_annonce_complet_current_month> getV_annonce_complet_current_monthByIdTransmission(Integer IdTransmission, Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findByIdTransmission(IdTransmission, pageable);
    }

    public Page<V_annonce_complet_current_month> getV_annonce_complet_current_monthByIdUsage(Integer IdUsage, Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findByIdUsage(IdUsage, pageable);
    }

    public Page<V_annonce_complet_current_month> getV_annonce_complet_current_monthByIdCouleur(Integer IdCouleur, Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findByIdCouleur(IdCouleur, pageable);
    }

    public Page<V_annonce_complet_current_month> getV_annonce_complet_current_monthByIdTypeAnnonce(Integer IdTypeAnnonce, Pageable pageable) {
        return v_annonce_complet_current_monthRepository.findByIdTypeAnnonce(IdTypeAnnonce, pageable);
    }

    // Add your service methods here

}
