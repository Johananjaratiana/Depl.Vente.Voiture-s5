package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Energie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnergieRepository extends JpaRepository<Energie, Long> {
    @Query("SELECT tbl FROM energie tbl")
   Page<Energie> findAll(Pageable pageable);

}
