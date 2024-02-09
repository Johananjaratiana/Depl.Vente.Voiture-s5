package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.PhotoAnnonce;
import com.vente.voiture.crud.repository.PhotoAnnonceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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
    public List<PhotoAnnonce> getAllphoto_annonce() {
        return photo_annonceRepository.findAll();
    }

    // Read
    public Page<PhotoAnnonce> getAllPhotoAnnonce(Pageable pageable) {
        return photo_annonceRepository.findAll(pageable);
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

    public Page<PhotoAnnonce> getPhotoAnnonceByIdAnnonce(Integer IdAnnonce, Pageable pageable) {
        return photo_annonceRepository.findByIdAnnonce(IdAnnonce, pageable);
    }

    // Add your service methods here

}
