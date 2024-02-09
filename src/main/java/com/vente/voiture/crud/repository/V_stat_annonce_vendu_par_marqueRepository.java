package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_stat_annonce_vendu_par_marque;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_stat_annonce_vendu_par_marqueRepository extends JpaRepository<V_stat_annonce_vendu_par_marque, Long> {
    @Query("SELECT tbl FROM v_stat_annonce_vendu_par_marque tbl WHERE tbl.IdMarque = ?1")
   Page<V_stat_annonce_vendu_par_marque> findByIdMarque(Integer IdMarque, Pageable pageable);

   @Query("SELECT tbl FROM v_stat_annonce_vendu_par_marque tbl")
   Page<V_stat_annonce_vendu_par_marque> findAll(Pageable pageable);

}
