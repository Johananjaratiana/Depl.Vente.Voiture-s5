package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_annonce_complet_ordered_by_type_annonce;
import com.vente.voiture.crud.repository.V_annonce_complet_ordered_by_type_annonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class V_annonce_complet_ordered_by_type_annonceService {
    @Autowired
    private V_annonce_complet_ordered_by_type_annonceRepository v_annonce_complet_ordered_by_type_annonceRepository;

    // Read
    public List<V_annonce_complet_ordered_by_type_annonce> getAllV_annonce_complet_ordered_by_type_annonce() {
        return (List<V_annonce_complet_ordered_by_type_annonce>) v_annonce_complet_ordered_by_type_annonceRepository.findAll();
    }

    // GetById
    public Optional<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceById(Long id) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findById(id);
    }

    public List<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdModele(Integer IdModele) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdModele(IdModele);
    }

    public List<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdMarque(Integer IdMarque) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdMarque(IdMarque);
    }

    public List<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdTypeMoteur(Integer IdTypeMoteur) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdTypeMoteur(IdTypeMoteur);
    }

    public List<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdTaille(Integer IdTaille) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdTaille(IdTaille);
    }

    public List<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdUsers(Integer IdUsers) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdUsers(IdUsers);
    }

    public List<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdEnergie(Integer IdEnergie) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdEnergie(IdEnergie);
    }

    public List<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdTransmission(Integer IdTransmission) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdTransmission(IdTransmission);
    }

    public List<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdUsage(Integer IdUsage) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdUsage(IdUsage);
    }

    public List<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdCouleur(Integer IdCouleur) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdCouleur(IdCouleur);
    }

    public List<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdTypeAnnonce(Integer IdTypeAnnonce) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdTypeAnnonce(IdTypeAnnonce);
    }

    // Add your service methods here

}
