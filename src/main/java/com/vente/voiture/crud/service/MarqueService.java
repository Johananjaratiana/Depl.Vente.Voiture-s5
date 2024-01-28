package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.Marque;
import com.vente.voiture.crud.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class MarqueService {
    @Autowired
    private MarqueRepository marqueRepository;

    // Create
    public Marque save(Marque marque) {
        return marqueRepository.save(marque);
    }

    // Read
    public List<Marque> getAllMarque() {
        return (List<Marque>) marqueRepository.findAll();
    }

    // GetById
    public Optional<Marque> getMarqueById(Long id) {
        return marqueRepository.findById(id);
    }

    // Update
    public Marque updateMarque(Long id, Marque updatedMarque) {
        if (marqueRepository.existsById(id)) {
            updatedMarque.setId(id);
            return marqueRepository.save(updatedMarque);
        }
        return null; // not found
    }

    // Delete
    public void deleteMarque(Long id) {
        marqueRepository.deleteById(id);
    }

    // Add your service methods here

}
