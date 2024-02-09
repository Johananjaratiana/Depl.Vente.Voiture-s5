package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.EtatAnnonce;
import com.vente.voiture.crud.repository.EtatAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class EtatAnnonceService {
    @Autowired
    private EtatAnnonceRepository etat_annonceRepository;

    // Create
    public EtatAnnonce save(EtatAnnonce etat_annonce) {
        return etat_annonceRepository.save(etat_annonce);
    }

    // Read
    public List<EtatAnnonce> getAlletat_annonce() {
        return etat_annonceRepository.findAll();
    }

    // Read
    public Page<EtatAnnonce> getAllEtatAnnonce(Pageable pageable) {
        return etat_annonceRepository.findAll(pageable);
    }

    // GetById
    public Optional<EtatAnnonce> getEtatAnnonceById(Long id) {
        return etat_annonceRepository.findById(id);
    }

    // Update
    public EtatAnnonce updateEtatAnnonce(Long id, EtatAnnonce updatedEtatAnnonce) {
        if (etat_annonceRepository.existsById(id)) {
            updatedEtatAnnonce.setId(id);
            return etat_annonceRepository.save(updatedEtatAnnonce);
        }
        return null; // not found
    }

    // Delete
    public void deleteEtatAnnonce(Long id) {
        etat_annonceRepository.deleteById(id);
    }

    public Page<EtatAnnonce> getEtatAnnonceByIdAnnonce(Integer IdAnnonce, Pageable pageable) {
        return etat_annonceRepository.findByIdAnnonce(IdAnnonce, pageable);
    }

    // Add your service methods here

}
