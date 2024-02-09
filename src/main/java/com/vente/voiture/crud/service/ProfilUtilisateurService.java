package com.vente.voiture.crud.service;

import com.vente.voiture.crud.model.ProfilUtilisateur;
import com.vente.voiture.crud.repository.ProfilUtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ProfilUtilisateurService {
    @Autowired
    private ProfilUtilisateurRepository profil_utilisateurRepository;

    // Create
    public ProfilUtilisateur save(ProfilUtilisateur profil_utilisateur) {
        return profil_utilisateurRepository.save(profil_utilisateur);
    }

    // Read
    public List<ProfilUtilisateur> getAllprofil_utilisateur() {
        return profil_utilisateurRepository.findAll();
    }

    // Read
    public Page<ProfilUtilisateur> getAllProfilUtilisateur(Pageable pageable) {
        return profil_utilisateurRepository.findAll(pageable);
    }

    // GetById
    public Optional<ProfilUtilisateur> getProfilUtilisateurById(Long id) {
        return profil_utilisateurRepository.findById(id);
    }

    // Update
    public ProfilUtilisateur updateProfilUtilisateur(Long id, ProfilUtilisateur updatedProfilUtilisateur) {
        if (profil_utilisateurRepository.existsById(id)) {
            updatedProfilUtilisateur.setId(id);
            return profil_utilisateurRepository.save(updatedProfilUtilisateur);
        }
        return null; // not found
    }

    // Delete
    public void deleteProfilUtilisateur(Long id) {
        profil_utilisateurRepository.deleteById(id);
    }

    // Add your service methods here

}
