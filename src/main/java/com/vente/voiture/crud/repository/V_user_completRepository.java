package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_user_complet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_user_completRepository extends JpaRepository<V_user_complet, Long> {
    @Query("SELECT tbl FROM v_user_complet tbl WHERE tbl.Idprofile = ?1")
   Page<V_user_complet> findByIdprofile(Integer Idprofile, Pageable pageable);

   @Query("SELECT tbl FROM v_user_complet tbl")
   Page<V_user_complet> findAll(Pageable pageable);

}
