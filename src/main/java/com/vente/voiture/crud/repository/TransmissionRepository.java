package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Transmission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransmissionRepository extends JpaRepository<Transmission, Long> {
    @Query("SELECT tbl FROM transmission tbl")
   Page<Transmission> findAll(Pageable pageable);

}
