package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.TypeMoteur;
import com.vente.voiture.crud.repository.TypeMoteurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class TypeMoteurService {
    @Autowired
    private TypeMoteurRepository type_moteurRepository;

    // Create
    public TypeMoteur save(TypeMoteur type_moteur) {
        return type_moteurRepository.save(type_moteur);
    }

    // Read
    public List<TypeMoteur> getAllTypeMoteur() {
        return (List<TypeMoteur>) type_moteurRepository.findAll();
    }

    // GetById
    public Optional<TypeMoteur> getTypeMoteurById(Long id) {
        return type_moteurRepository.findById(id);
    }

    // Update
    public TypeMoteur updateTypeMoteur(Long id, TypeMoteur updatedTypeMoteur) {
        if (type_moteurRepository.existsById(id)) {
            updatedTypeMoteur.setId(id);
            return type_moteurRepository.save(updatedTypeMoteur);
        }
        return null; // not found
    }

    // Delete
    public void deleteTypeMoteur(Long id) {
        type_moteurRepository.deleteById(id);
    }

    // Add your service methods here

}
