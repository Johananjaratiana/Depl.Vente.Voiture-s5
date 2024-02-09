package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.V_annonce_complet_ordered_by_type_annonce;
import com.vente.voiture.crud.repository.V_annonce_complet_ordered_by_type_annonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class V_annonce_complet_ordered_by_type_annonceService {
    @Autowired
    private V_annonce_complet_ordered_by_type_annonceRepository v_annonce_complet_ordered_by_type_annonceRepository;

    // Read
    public List<V_annonce_complet_ordered_by_type_annonce> getAllV_annonce_complet_ordered_by_type_annonce() {
        return v_annonce_complet_ordered_by_type_annonceRepository.findAll();
    }

    // Read
    public Page<V_annonce_complet_ordered_by_type_annonce> getAllV_annonce_complet_ordered_by_type_annonce(Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findAll(pageable);
    }

    // GetById
    public Optional<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceById(Long id) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findById(id);
    }

    public Page<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdModele(Integer IdModele, Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdModele(IdModele, pageable);
    }

    public Page<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdMarque(Integer IdMarque, Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdMarque(IdMarque, pageable);
    }

    public Page<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdTypeMoteur(Integer IdTypeMoteur, Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdTypeMoteur(IdTypeMoteur, pageable);
    }

    public Page<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdTaille(Integer IdTaille, Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdTaille(IdTaille, pageable);
    }

    public Page<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdUsers(Integer IdUsers, Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdUsers(IdUsers, pageable);
    }

    public Page<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdEnergie(Integer IdEnergie, Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdEnergie(IdEnergie, pageable);
    }

    public Page<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdTransmission(Integer IdTransmission, Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdTransmission(IdTransmission, pageable);
    }

    public Page<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdUsage(Integer IdUsage, Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdUsage(IdUsage, pageable);
    }

    public Page<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdCouleur(Integer IdCouleur, Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdCouleur(IdCouleur, pageable);
    }

    public Page<V_annonce_complet_ordered_by_type_annonce> getV_annonce_complet_ordered_by_type_annonceByIdTypeAnnonce(Integer IdTypeAnnonce, Pageable pageable) {
        return v_annonce_complet_ordered_by_type_annonceRepository.findByIdTypeAnnonce(IdTypeAnnonce, pageable);
    }

    // Add your service methods here

}
