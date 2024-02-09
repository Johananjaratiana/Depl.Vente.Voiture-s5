package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_count_annonce_valide_current_year;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_count_annonce_valide_current_yearRepository extends JpaRepository<V_count_annonce_valide_current_year, Long> {
    @Query("SELECT tbl FROM v_count_annonce_valide_current_year tbl WHERE tbl.NbAnnonceValide = ?1")
   Page<V_count_annonce_valide_current_year> findByNbAnnonceValide(Integer NbAnnonceValide, Pageable pageable);

   @Query("SELECT tbl FROM v_count_annonce_valide_current_year tbl")
   Page<V_count_annonce_valide_current_year> findAll(Pageable pageable);

}
