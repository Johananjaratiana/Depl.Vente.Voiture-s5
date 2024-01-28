package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.AnnonceFavoris;
import com.vente.voiture.crud.repository.AnnonceFavorisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.stereotype.Service;

@Service
public class AnnonceFavorisService {
    @Autowired
    private AnnonceFavorisRepository annonce_favorisRepository;

    // Create
    public AnnonceFavoris save(AnnonceFavoris annonce_favoris) {
        return annonce_favorisRepository.save(annonce_favoris);
    }

    // Read
    public List<AnnonceFavoris> getAllAnnonceFavoris() {
        return (List<AnnonceFavoris>) annonce_favorisRepository.findAll();
    }

    // GetById
    public Optional<AnnonceFavoris> getAnnonceFavorisById(Long id) {
        return annonce_favorisRepository.findById(id);
    }

    // Update
    public AnnonceFavoris updateAnnonceFavoris(Long id, AnnonceFavoris updatedAnnonceFavoris) {
        if (annonce_favorisRepository.existsById(id)) {
            updatedAnnonceFavoris.setId(id);
            return annonce_favorisRepository.save(updatedAnnonceFavoris);
        }
        return null; // not found
    }

    // Delete
    public void deleteAnnonceFavoris(Long id) {
        annonce_favorisRepository.deleteById(id);
    }

    public List<AnnonceFavoris> getAnnonceFavorisByIdAnnonce(Integer IdAnnonce) {
        return annonce_favorisRepository.findByIdAnnonce(IdAnnonce);
    }

    public List<AnnonceFavoris> getAnnonceFavorisByIdUsers(Integer IdUsers) {
        return annonce_favorisRepository.findByIdUsers(IdUsers);
    }

    // Add your service methods here

}
