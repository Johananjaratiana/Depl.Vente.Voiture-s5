package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.EtatAnnonce;
import com.vente.voiture.crud.repository.EtatAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
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
    public List<EtatAnnonce> getAllEtatAnnonce() {
        return (List<EtatAnnonce>) etat_annonceRepository.findAll();
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

    public List<EtatAnnonce> getEtatAnnonceByIdAnnonce(Integer IdAnnonce) {
        return etat_annonceRepository.findByIdAnnonce(IdAnnonce);
    }

    // Add your service methods here

}
