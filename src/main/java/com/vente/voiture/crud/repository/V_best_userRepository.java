package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_best_user;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_best_userRepository extends JpaRepository<V_best_user, Long> {
    @Query("SELECT tbl FROM v_best_user tbl WHERE tbl.Idprofile = ?1")
   Page<V_best_user> findByIdprofile(Integer Idprofile, Pageable pageable);

   @Query("SELECT tbl FROM v_best_user tbl")
   Page<V_best_user> findAll(Pageable pageable);

}
