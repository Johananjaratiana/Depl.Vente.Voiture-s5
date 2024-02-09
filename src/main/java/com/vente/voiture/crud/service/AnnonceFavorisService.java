package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.AnnonceFavoris;
import com.vente.voiture.crud.repository.AnnonceFavorisRepository;
import com.vente.voiture.ws.security.user.Users;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
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
    public List<AnnonceFavoris> getAllannonce_favoris() {
        return annonce_favorisRepository.findAll();
    }

    // Read
    public Page<AnnonceFavoris> getAllAnnonceFavoris(Pageable pageable) {
        return annonce_favorisRepository.findAll(pageable);
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

    public Page<AnnonceFavoris> getAnnonceFavorisByIdAnnonce(Integer IdAnnonce, Pageable pageable) {
        return annonce_favorisRepository.findByIdAnnonce(IdAnnonce, pageable);
    }

    public Page<AnnonceFavoris> getAnnonceFavorisByIdUsers(Integer IdUsers, Pageable pageable) {
        return annonce_favorisRepository.findByIdUsers(IdUsers, pageable);
    }

    // Add your service methods here

    public AnnonceFavoris isFavorite(Integer id_annonce, Users users) {
        List<AnnonceFavoris> annonceFavoris = annonce_favorisRepository.findByIdAnnonceAndIdUsers(id_annonce.longValue(), users.getId());
        return (annonceFavoris.size() > 0) ? annonceFavoris.get(0) : null;
    }

}
