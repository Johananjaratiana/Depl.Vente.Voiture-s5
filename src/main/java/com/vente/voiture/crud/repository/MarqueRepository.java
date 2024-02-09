package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Marque;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarqueRepository extends JpaRepository<Marque, Long> {
    @Query("SELECT tbl FROM marque tbl")
   Page<Marque> findAll(Pageable pageable);

}
