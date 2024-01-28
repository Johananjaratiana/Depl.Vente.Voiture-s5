package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.TypeAnnonce;
import com.vente.voiture.crud.repository.TypeAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class TypeAnnonceService {
    @Autowired
    private TypeAnnonceRepository type_annonceRepository;

    // Create
    public TypeAnnonce save(TypeAnnonce type_annonce) {
        return type_annonceRepository.save(type_annonce);
    }

    // Read
    public List<TypeAnnonce> getAllTypeAnnonce() {
        return (List<TypeAnnonce>) type_annonceRepository.findAll();
    }

    // GetById
    public Optional<TypeAnnonce> getTypeAnnonceById(Long id) {
        return type_annonceRepository.findById(id);
    }

    // Update
    public TypeAnnonce updateTypeAnnonce(Long id, TypeAnnonce updatedTypeAnnonce) {
        if (type_annonceRepository.existsById(id)) {
            updatedTypeAnnonce.setId(id);
            return type_annonceRepository.save(updatedTypeAnnonce);
        }
        return null; // not found
    }

    // Delete
    public void deleteTypeAnnonce(Long id) {
        type_annonceRepository.deleteById(id);
    }

    // Add your service methods here

}
