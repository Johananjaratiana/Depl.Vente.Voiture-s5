package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Annonce;
import com.vente.voiture.crud.repository.AnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class AnnonceService {
    @Autowired
    private AnnonceRepository annonceRepository;

    // Create
    public Annonce save(Annonce annonce) {
        return annonceRepository.save(annonce);
    }

    // Read
    public List<Annonce> getAllAnnonce() {
        return (List<Annonce>) annonceRepository.findAll();
    }

    // GetById
    public Optional<Annonce> getAnnonceById(Long id) {
        return annonceRepository.findById(id);
    }

    // Update
    public Annonce updateAnnonce(Long id, Annonce updatedAnnonce) {
        if (annonceRepository.existsById(id)) {
            updatedAnnonce.setId(id);
            return annonceRepository.save(updatedAnnonce);
        }
        return null; // not found
    }

    // Delete
    public void deleteAnnonce(Long id) {
        annonceRepository.deleteById(id);
    }

    public List<Annonce> getAnnonceByIdModele(Integer IdModele) {
        return annonceRepository.findByIdModele(IdModele);
    }

    public List<Annonce> getAnnonceByIdMarque(Integer IdMarque) {
        return annonceRepository.findByIdMarque(IdMarque);
    }

    public List<Annonce> getAnnonceByIdTypeMoteur(Integer IdTypeMoteur) {
        return annonceRepository.findByIdTypeMoteur(IdTypeMoteur);
    }

    public List<Annonce> getAnnonceByIdUsers(Integer IdUsers) {
        return annonceRepository.findByIdUsers(IdUsers);
    }

    public List<Annonce> getAnnonceByIdEnergie(Integer IdEnergie) {
        return annonceRepository.findByIdEnergie(IdEnergie);
    }

    public List<Annonce> getAnnonceByIdTransmission(Integer IdTransmission) {
        return annonceRepository.findByIdTransmission(IdTransmission);
    }

    public List<Annonce> getAnnonceByIdUsage(Integer IdUsage) {
        return annonceRepository.findByIdUsage(IdUsage);
    }

    public List<Annonce> getAnnonceByIdCouleur(Integer IdCouleur) {
        return annonceRepository.findByIdCouleur(IdCouleur);
    }

    public List<Annonce> getAnnonceByIdTaille(Integer IdTaille) {
        return annonceRepository.findByIdTaille(IdTaille);
    }

    public List<Annonce> getAnnonceByIdTypeAnnonce(Integer IdTypeAnnonce) {
        return annonceRepository.findByIdTypeAnnonce(IdTypeAnnonce);
    }

    // Add your service methods here

}
