package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Taille;
import com.vente.voiture.crud.repository.TailleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class TailleService {
    @Autowired
    private TailleRepository tailleRepository;

    // Create
    public Taille save(Taille taille) {
        return tailleRepository.save(taille);
    }

    // Read
    public List<Taille> getAllTaille() {
        return (List<Taille>) tailleRepository.findAll();
    }

    // GetById
    public Optional<Taille> getTailleById(Long id) {
        return tailleRepository.findById(id);
    }

    // Update
    public Taille updateTaille(Long id, Taille updatedTaille) {
        if (tailleRepository.existsById(id)) {
            updatedTaille.setId(id);
            return tailleRepository.save(updatedTaille);
        }
        return null; // not found
    }

    // Delete
    public void deleteTaille(Long id) {
        tailleRepository.deleteById(id);
    }

    // Add your service methods here

}
