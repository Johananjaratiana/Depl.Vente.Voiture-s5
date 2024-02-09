package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_nombre_important;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_nombre_importantRepository extends JpaRepository<V_nombre_important, Long> {
    @Query("SELECT tbl FROM v_nombre_important tbl WHERE tbl.NbAnnonceValide = ?1")
   Page<V_nombre_important> findByNbAnnonceValide(Integer NbAnnonceValide, Pageable pageable);

   @Query("SELECT tbl FROM v_nombre_important tbl")
   Page<V_nombre_important> findAll(Pageable pageable);

}
