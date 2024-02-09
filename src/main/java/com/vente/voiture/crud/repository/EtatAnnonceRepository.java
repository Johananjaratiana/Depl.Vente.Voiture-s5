package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.EtatAnnonce;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatAnnonceRepository extends JpaRepository<EtatAnnonce, Long> {
    @Query("SELECT tbl FROM etat_annonce tbl WHERE tbl.IdAnnonce = ?1")
   Page<EtatAnnonce> findByIdAnnonce(Integer IdAnnonce, Pageable pageable);

   @Query("SELECT tbl FROM etat_annonce tbl")
   Page<EtatAnnonce> findAll(Pageable pageable);

}
