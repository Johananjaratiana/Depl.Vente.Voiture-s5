package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Modele;
import com.vente.voiture.crud.repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ModeleService {
    @Autowired
    private ModeleRepository modeleRepository;

    // Create
    public Modele save(Modele modele) {
        return modeleRepository.save(modele);
    }

    // Read
    public List<Modele> getAllmodele() {
        return modeleRepository.findAll();
    }

    // Read
    public Page<Modele> getAllModele(Pageable pageable) {
        return modeleRepository.findAll(pageable);
    }

    // GetById
    public Optional<Modele> getModeleById(Long id) {
        return modeleRepository.findById(id);
    }

    // Update
    public Modele updateModele(Long id, Modele updatedModele) {
        if (modeleRepository.existsById(id)) {
            updatedModele.setId(id);
            return modeleRepository.save(updatedModele);
        }
        return null; // not found
    }

    // Delete
    public void deleteModele(Long id) {
        modeleRepository.deleteById(id);
    }

    // Add your service methods here

}
