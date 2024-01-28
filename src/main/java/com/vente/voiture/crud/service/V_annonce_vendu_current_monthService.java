package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_annonce_vendu_current_month;
import com.vente.voiture.crud.repository.V_annonce_vendu_current_monthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_annonce_vendu_current_monthService {
    @Autowired
    private V_annonce_vendu_current_monthRepository v_annonce_vendu_current_monthRepository;

    // Read
    public List<V_annonce_vendu_current_month> getAllV_annonce_vendu_current_month() {
        return (List<V_annonce_vendu_current_month>) v_annonce_vendu_current_monthRepository.findAll();
    }

    // GetById
    public Optional<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthById(Long id) {
        return v_annonce_vendu_current_monthRepository.findById(id);
    }

    public List<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthByIdTypeMoteur(Integer IdTypeMoteur) {
        return v_annonce_vendu_current_monthRepository.findByIdTypeMoteur(IdTypeMoteur);
    }

    public List<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthByIdTaille(Integer IdTaille) {
        return v_annonce_vendu_current_monthRepository.findByIdTaille(IdTaille);
    }

    public List<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthByIdTransmission(Integer IdTransmission) {
        return v_annonce_vendu_current_monthRepository.findByIdTransmission(IdTransmission);
    }

    public List<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthByIdCouleur(Integer IdCouleur) {
        return v_annonce_vendu_current_monthRepository.findByIdCouleur(IdCouleur);
    }

    public List<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthByIdTypeAnnonce(Integer IdTypeAnnonce) {
        return v_annonce_vendu_current_monthRepository.findByIdTypeAnnonce(IdTypeAnnonce);
    }

    public List<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthByIdModele(Integer IdModele) {
        return v_annonce_vendu_current_monthRepository.findByIdModele(IdModele);
    }

    public List<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthByIdMarque(Integer IdMarque) {
        return v_annonce_vendu_current_monthRepository.findByIdMarque(IdMarque);
    }

    public List<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthByIdUsers(Integer IdUsers) {
        return v_annonce_vendu_current_monthRepository.findByIdUsers(IdUsers);
    }

    public List<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthByIdEnergie(Integer IdEnergie) {
        return v_annonce_vendu_current_monthRepository.findByIdEnergie(IdEnergie);
    }

    public List<V_annonce_vendu_current_month> getV_annonce_vendu_current_monthByIdUsage(Integer IdUsage) {
        return v_annonce_vendu_current_monthRepository.findByIdUsage(IdUsage);
    }

    // Add your service methods here

}
