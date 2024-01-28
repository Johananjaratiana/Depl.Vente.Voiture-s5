package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Modele;
import com.vente.voiture.crud.repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
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
    public List<Modele> getAllModele() {
        return (List<Modele>) modeleRepository.findAll();
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
