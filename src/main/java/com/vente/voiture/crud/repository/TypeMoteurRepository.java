package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.TypeMoteur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeMoteurRepository extends JpaRepository<TypeMoteur, Long> {
    @Query("SELECT tbl FROM type_moteur tbl")
   Page<TypeMoteur> findAll(Pageable pageable);

}
