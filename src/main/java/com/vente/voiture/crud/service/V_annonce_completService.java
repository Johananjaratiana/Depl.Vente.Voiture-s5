package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_annonce_complet;
import com.vente.voiture.crud.repository.V_annonce_completRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_annonce_completService {
    @Autowired
    private V_annonce_completRepository v_annonce_completRepository;

    // Read
    public List<V_annonce_complet> getAllV_annonce_complet() {
        return (List<V_annonce_complet>) v_annonce_completRepository.findAll();
    }

    // GetById
    public Optional<V_annonce_complet> getV_annonce_completById(Long id) {
        return v_annonce_completRepository.findById(id);
    }

    public List<V_annonce_complet> getV_annonce_completByIdModele(Integer IdModele) {
        return v_annonce_completRepository.findByIdModele(IdModele);
    }

    public List<V_annonce_complet> getV_annonce_completByIdMarque(Integer IdMarque) {
        return v_annonce_completRepository.findByIdMarque(IdMarque);
    }

    public List<V_annonce_complet> getV_annonce_completByIdTypeMoteur(Integer IdTypeMoteur) {
        return v_annonce_completRepository.findByIdTypeMoteur(IdTypeMoteur);
    }

    public List<V_annonce_complet> getV_annonce_completByIdTaille(Integer IdTaille) {
        return v_annonce_completRepository.findByIdTaille(IdTaille);
    }

    public List<V_annonce_complet> getV_annonce_completByIdUsers(Integer IdUsers) {
        return v_annonce_completRepository.findByIdUsers(IdUsers);
    }

    public List<V_annonce_complet> getV_annonce_completByIdEnergie(Integer IdEnergie) {
        return v_annonce_completRepository.findByIdEnergie(IdEnergie);
    }

    public List<V_annonce_complet> getV_annonce_completByIdTransmission(Integer IdTransmission) {
        return v_annonce_completRepository.findByIdTransmission(IdTransmission);
    }

    public List<V_annonce_complet> getV_annonce_completByIdUsage(Integer IdUsage) {
        return v_annonce_completRepository.findByIdUsage(IdUsage);
    }

    public List<V_annonce_complet> getV_annonce_completByIdCouleur(Integer IdCouleur) {
        return v_annonce_completRepository.findByIdCouleur(IdCouleur);
    }

    public List<V_annonce_complet> getV_annonce_completByIdTypeAnnonce(Integer IdTypeAnnonce) {
        return v_annonce_completRepository.findByIdTypeAnnonce(IdTypeAnnonce);
    }

    // Add your service methods here

}
