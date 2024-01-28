package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Couleur;
import com.vente.voiture.crud.repository.CouleurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class CouleurService {
    @Autowired
    private CouleurRepository couleurRepository;

    // Create
    public Couleur save(Couleur couleur) {
        return couleurRepository.save(couleur);
    }

    // Read
    public List<Couleur> getAllCouleur() {
        return (List<Couleur>) couleurRepository.findAll();
    }

    // GetById
    public Optional<Couleur> getCouleurById(Long id) {
        return couleurRepository.findById(id);
    }

    // Update
    public Couleur updateCouleur(Long id, Couleur updatedCouleur) {
        if (couleurRepository.existsById(id)) {
            updatedCouleur.setId(id);
            return couleurRepository.save(updatedCouleur);
        }
        return null; // not found
    }

    // Delete
    public void deleteCouleur(Long id) {
        couleurRepository.deleteById(id);
    }

    // Add your service methods here

}
