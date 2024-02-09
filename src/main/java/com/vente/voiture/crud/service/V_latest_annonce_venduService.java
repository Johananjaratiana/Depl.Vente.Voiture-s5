package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_latest_annonce_vendu;
import com.vente.voiture.crud.repository.V_latest_annonce_venduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class V_latest_annonce_venduService {
    @Autowired
    private V_latest_annonce_venduRepository v_latest_annonce_venduRepository;

    // Read
    public List<V_latest_annonce_vendu> getAllV_latest_annonce_vendu() {
        return v_latest_annonce_venduRepository.findAll();
    }

    // Read
    public Page<V_latest_annonce_vendu> getAllV_latest_annonce_vendu(Pageable pageable) {
        return v_latest_annonce_venduRepository.findAll(pageable);
    }

    // GetById
    public Optional<V_latest_annonce_vendu> getV_latest_annonce_venduById(Long id) {
        return v_latest_annonce_venduRepository.findById(id);
    }

    public Page<V_latest_annonce_vendu> getV_latest_annonce_venduByIdTypeMoteur(Integer IdTypeMoteur, Pageable pageable) {
        return v_latest_annonce_venduRepository.findByIdTypeMoteur(IdTypeMoteur, pageable);
    }

    public Page<V_latest_annonce_vendu> getV_latest_annonce_venduByIdTaille(Integer IdTaille, Pageable pageable) {
        return v_latest_annonce_venduRepository.findByIdTaille(IdTaille, pageable);
    }

    public Page<V_latest_annonce_vendu> getV_latest_annonce_venduByIdTransmission(Integer IdTransmission, Pageable pageable) {
        return v_latest_annonce_venduRepository.findByIdTransmission(IdTransmission, pageable);
    }

    public Page<V_latest_annonce_vendu> getV_latest_annonce_venduByIdCouleur(Integer IdCouleur, Pageable pageable) {
        return v_latest_annonce_venduRepository.findByIdCouleur(IdCouleur, pageable);
    }

    public Page<V_latest_annonce_vendu> getV_latest_annonce_venduByIdTypeAnnonce(Integer IdTypeAnnonce, Pageable pageable) {
        return v_latest_annonce_venduRepository.findByIdTypeAnnonce(IdTypeAnnonce, pageable);
    }

    public Page<V_latest_annonce_vendu> getV_latest_annonce_venduByIdModele(Integer IdModele, Pageable pageable) {
        return v_latest_annonce_venduRepository.findByIdModele(IdModele, pageable);
    }

    public Page<V_latest_annonce_vendu> getV_latest_annonce_venduByIdMarque(Integer IdMarque, Pageable pageable) {
        return v_latest_annonce_venduRepository.findByIdMarque(IdMarque, pageable);
    }

    public Page<V_latest_annonce_vendu> getV_latest_annonce_venduByIdUsers(Integer IdUsers, Pageable pageable) {
        return v_latest_annonce_venduRepository.findByIdUsers(IdUsers, pageable);
    }

    public Page<V_latest_annonce_vendu> getV_latest_annonce_venduByIdEnergie(Integer IdEnergie, Pageable pageable) {
        return v_latest_annonce_venduRepository.findByIdEnergie(IdEnergie, pageable);
    }

    public Page<V_latest_annonce_vendu> getV_latest_annonce_venduByIdUsage(Integer IdUsage, Pageable pageable) {
        return v_latest_annonce_venduRepository.findByIdUsage(IdUsage, pageable);
    }

    // Add your service methods here

}
