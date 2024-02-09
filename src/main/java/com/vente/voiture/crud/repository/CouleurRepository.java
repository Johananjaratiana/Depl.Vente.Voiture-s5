package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Couleur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouleurRepository extends JpaRepository<Couleur, Long> {
    @Query("SELECT tbl FROM couleur tbl")
   Page<Couleur> findAll(Pageable pageable);

}
