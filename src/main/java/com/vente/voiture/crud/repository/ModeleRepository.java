package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Modele;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeleRepository extends JpaRepository<Modele, Long> {
    @Query("SELECT tbl FROM modele tbl")
   Page<Modele> findAll(Pageable pageable);

}
