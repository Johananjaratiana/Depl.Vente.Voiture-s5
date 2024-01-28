package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Energie;
import com.vente.voiture.crud.repository.EnergieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class EnergieService {
    @Autowired
    private EnergieRepository energieRepository;

    // Create
    public Energie save(Energie energie) {
        return energieRepository.save(energie);
    }

    // Read
    public List<Energie> getAllEnergie() {
        return (List<Energie>) energieRepository.findAll();
    }

    // GetById
    public Optional<Energie> getEnergieById(Long id) {
        return energieRepository.findById(id);
    }

    // Update
    public Energie updateEnergie(Long id, Energie updatedEnergie) {
        if (energieRepository.existsById(id)) {
            updatedEnergie.setId(id);
            return energieRepository.save(updatedEnergie);
        }
        return null; // not found
    }

    // Delete
    public void deleteEnergie(Long id) {
        energieRepository.deleteById(id);
    }

    // Add your service methods here

}
