package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_latest_annonce_vendu;
import com.vente.voiture.crud.repository.V_latest_annonce_venduRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_latest_annonce_venduService {
    @Autowired
    private V_latest_annonce_venduRepository v_latest_annonce_venduRepository;

    // Read
    public List<V_latest_annonce_vendu> getAllV_latest_annonce_vendu() {
        return (List<V_latest_annonce_vendu>) v_latest_annonce_venduRepository.findAll();
    }

    // GetById
    public Optional<V_latest_annonce_vendu> getV_latest_annonce_venduById(Long id) {
        return v_latest_annonce_venduRepository.findById(id);
    }

    public List<V_latest_annonce_vendu> getV_latest_annonce_venduByIdTypeMoteur(Integer IdTypeMoteur) {
        return v_latest_annonce_venduRepository.findByIdTypeMoteur(IdTypeMoteur);
    }

    public List<V_latest_annonce_vendu> getV_latest_annonce_venduByIdTaille(Integer IdTaille) {
        return v_latest_annonce_venduRepository.findByIdTaille(IdTaille);
    }

    public List<V_latest_annonce_vendu> getV_latest_annonce_venduByIdTransmission(Integer IdTransmission) {
        return v_latest_annonce_venduRepository.findByIdTransmission(IdTransmission);
    }

    public List<V_latest_annonce_vendu> getV_latest_annonce_venduByIdCouleur(Integer IdCouleur) {
        return v_latest_annonce_venduRepository.findByIdCouleur(IdCouleur);
    }

    public List<V_latest_annonce_vendu> getV_latest_annonce_venduByIdTypeAnnonce(Integer IdTypeAnnonce) {
        return v_latest_annonce_venduRepository.findByIdTypeAnnonce(IdTypeAnnonce);
    }

    public List<V_latest_annonce_vendu> getV_latest_annonce_venduByIdModele(Integer IdModele) {
        return v_latest_annonce_venduRepository.findByIdModele(IdModele);
    }

    public List<V_latest_annonce_vendu> getV_latest_annonce_venduByIdMarque(Integer IdMarque) {
        return v_latest_annonce_venduRepository.findByIdMarque(IdMarque);
    }

    public List<V_latest_annonce_vendu> getV_latest_annonce_venduByIdUsers(Integer IdUsers) {
        return v_latest_annonce_venduRepository.findByIdUsers(IdUsers);
    }

    public List<V_latest_annonce_vendu> getV_latest_annonce_venduByIdEnergie(Integer IdEnergie) {
        return v_latest_annonce_venduRepository.findByIdEnergie(IdEnergie);
    }

    public List<V_latest_annonce_vendu> getV_latest_annonce_venduByIdUsage(Integer IdUsage) {
        return v_latest_annonce_venduRepository.findByIdUsage(IdUsage);
    }

    // Add your service methods here

}
