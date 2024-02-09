package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Annonce;
import com.vente.voiture.crud.repository.AnnonceRepository;
import com.vente.voiture.ws.security.user.Users;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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
    public List<Annonce> getAllannonce() {
        return annonceRepository.findAll();
    }

    // Read
    public Page<Annonce> getAllAnnonce(Pageable pageable) {
        return annonceRepository.findAll(pageable);
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

    public Page<Annonce> getAnnonceByIdModele(Integer IdModele, Pageable pageable) {
        return annonceRepository.findByIdModele(IdModele, pageable);
    }

    public Page<Annonce> getAnnonceByIdMarque(Integer IdMarque, Pageable pageable) {
        return annonceRepository.findByIdMarque(IdMarque, pageable);
    }

    public Page<Annonce> getAnnonceByIdTypeMoteur(Integer IdTypeMoteur, Pageable pageable) {
        return annonceRepository.findByIdTypeMoteur(IdTypeMoteur, pageable);
    }

    public Page<Annonce> getAnnonceByIdUsers(Integer IdUsers, Pageable pageable) {
        return annonceRepository.findByIdUsers(IdUsers, pageable);
    }

    public Page<Annonce> getAnnonceByIdEnergie(Integer IdEnergie, Pageable pageable) {
        return annonceRepository.findByIdEnergie(IdEnergie, pageable);
    }

    public Page<Annonce> getAnnonceByIdTransmission(Integer IdTransmission, Pageable pageable) {
        return annonceRepository.findByIdTransmission(IdTransmission, pageable);
    }

    public Page<Annonce> getAnnonceByIdUsage(Integer IdUsage, Pageable pageable) {
        return annonceRepository.findByIdUsage(IdUsage, pageable);
    }

    public Page<Annonce> getAnnonceByIdCouleur(Integer IdCouleur, Pageable pageable) {
        return annonceRepository.findByIdCouleur(IdCouleur, pageable);
    }

    public Page<Annonce> getAnnonceByIdTaille(Integer IdTaille, Pageable pageable) {
        return annonceRepository.findByIdTaille(IdTaille, pageable);
    }

    public Page<Annonce> getAnnonceByIdTypeAnnonce(Integer IdTypeAnnonce, Pageable pageable) {
        return annonceRepository.findByIdTypeAnnonce(IdTypeAnnonce, pageable);
    }

    public Boolean isFavorite(Integer id_annonce, Users users) {
        List<Object> ls = annonceRepository.findByIdAnnonceAndIdUsers(id_annonce.longValue(), users.getId());
        return (ls.size() > 0) ? true : false;
    }

    // Add your service methods here

}
