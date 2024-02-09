package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_user_ordered_by_commission;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_user_ordered_by_commissionRepository extends JpaRepository<V_user_ordered_by_commission, Long> {
    @Query("SELECT tbl FROM v_user_ordered_by_commission tbl WHERE tbl.Idprofile = ?1")
   Page<V_user_ordered_by_commission> findByIdprofile(Integer Idprofile, Pageable pageable);

   @Query("SELECT tbl FROM v_user_ordered_by_commission tbl")
   Page<V_user_ordered_by_commission> findAll(Pageable pageable);

}
