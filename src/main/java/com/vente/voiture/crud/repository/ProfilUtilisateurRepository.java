package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.ProfilUtilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfilUtilisateurRepository extends JpaRepository<ProfilUtilisateur, Long> {
    @Query("SELECT tbl FROM profil_utilisateur tbl")
   Page<ProfilUtilisateur> findAll(Pageable pageable);

}
