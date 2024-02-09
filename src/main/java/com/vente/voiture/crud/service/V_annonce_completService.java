package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_annonce_complet;
import com.vente.voiture.crud.repository.V_annonce_completRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class V_annonce_completService {
    @Autowired
    private V_annonce_completRepository v_annonce_completRepository;

    // Read
    public List<V_annonce_complet> getAllV_annonce_complet() {
        return v_annonce_completRepository.findAll();
    }

    // Read
    public Page<V_annonce_complet> getAllV_annonce_complet(Pageable pageable) {
        return v_annonce_completRepository.findAll(pageable);
    }

    // GetById
    public Optional<V_annonce_complet> getV_annonce_completById(Long id) {
        return v_annonce_completRepository.findById(id);
    }

    public Page<V_annonce_complet> getV_annonce_completByIdModele(Integer IdModele, Pageable pageable) {
        return v_annonce_completRepository.findByIdModele(IdModele, pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completByIdMarque(Integer IdMarque, Pageable pageable) {
        return v_annonce_completRepository.findByIdMarque(IdMarque, pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completByIdTypeMoteur(Integer IdTypeMoteur, Pageable pageable) {
        return v_annonce_completRepository.findByIdTypeMoteur(IdTypeMoteur, pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completByIdTaille(Integer IdTaille, Pageable pageable) {
        return v_annonce_completRepository.findByIdTaille(IdTaille, pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completByIdUsers(Integer IdUsers, Pageable pageable) {
        return v_annonce_completRepository.findByIdUsers(IdUsers, pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completByIdEnergie(Integer IdEnergie, Pageable pageable) {
        return v_annonce_completRepository.findByIdEnergie(IdEnergie, pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completByIdTransmission(Integer IdTransmission, Pageable pageable) {
        return v_annonce_completRepository.findByIdTransmission(IdTransmission, pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completByIdUsage(Integer IdUsage, Pageable pageable) {
        return v_annonce_completRepository.findByIdUsage(IdUsage, pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completByIdCouleur(Integer IdCouleur, Pageable pageable) {
        return v_annonce_completRepository.findByIdCouleur(IdCouleur, pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completByIdTypeAnnonce(Integer IdTypeAnnonce, Pageable pageable) {
        return v_annonce_completRepository.findByIdTypeAnnonce(IdTypeAnnonce, pageable);
    }

    // Add your service methods here

    // --------------- STATUS
    public Page<V_annonce_complet> getV_annonce_completNonValide(Pageable pageable) {
        return v_annonce_completRepository.findNonValide(pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completNonVendu(Pageable pageable) {
        return v_annonce_completRepository.findNonVendu(pageable);
    }

    public Page<V_annonce_complet> getV_annonce_completVendu(Pageable pageable) {
        return v_annonce_completRepository.findVendu(pageable);
    }

    // --------------- FAVORIS
    public Page<V_annonce_complet> getV_annonce_completFavorisByUsersId(Integer userId, Pageable pageable) {
        return v_annonce_completRepository.findFavorisByUsersId(userId, pageable);
    }


}
