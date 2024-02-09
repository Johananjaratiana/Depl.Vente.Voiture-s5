package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Taille;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TailleRepository extends JpaRepository<Taille, Long> {
    @Query("SELECT tbl FROM taille tbl")
   Page<Taille> findAll(Pageable pageable);

}
