package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Pdp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdpRepository extends JpaRepository<Pdp, Long> {
    @Query("SELECT tbl FROM pdp tbl WHERE tbl.IdUsers = ?1")
   Page<Pdp> findByIdUsers(Integer IdUsers, Pageable pageable);

   @Query("SELECT tbl FROM pdp tbl")
   Page<Pdp> findAll(Pageable pageable);

}
