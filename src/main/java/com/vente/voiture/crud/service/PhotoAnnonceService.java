package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.PhotoAnnonce;
import com.vente.voiture.crud.repository.PhotoAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class PhotoAnnonceService {
    @Autowired
    private PhotoAnnonceRepository photo_annonceRepository;

    // Create
    public PhotoAnnonce save(PhotoAnnonce photo_annonce) {
        return photo_annonceRepository.save(photo_annonce);
    }

    // Read
    public List<PhotoAnnonce> getAllPhotoAnnonce() {
        return (List<PhotoAnnonce>) photo_annonceRepository.findAll();
    }

    // GetById
    public Optional<PhotoAnnonce> getPhotoAnnonceById(Long id) {
        return photo_annonceRepository.findById(id);
    }

    // Update
    public PhotoAnnonce updatePhotoAnnonce(Long id, PhotoAnnonce updatedPhotoAnnonce) {
        if (photo_annonceRepository.existsById(id)) {
            updatedPhotoAnnonce.setId(id);
            return photo_annonceRepository.save(updatedPhotoAnnonce);
        }
        return null; // not found
    }

    // Delete
    public void deletePhotoAnnonce(Long id) {
        photo_annonceRepository.deleteById(id);
    }

    public List<PhotoAnnonce> getPhotoAnnonceByIdAnnonce(Integer IdAnnonce) {
        return photo_annonceRepository.findByIdAnnonce(IdAnnonce);
    }

    // Add your service methods here

}
