package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.PhotoAnnonce;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoAnnonceRepository extends JpaRepository<PhotoAnnonce, Long> {
    @Query("SELECT tbl FROM photo_annonce tbl WHERE tbl.IdAnnonce = ?1")
   Page<PhotoAnnonce> findByIdAnnonce(Integer IdAnnonce, Pageable pageable);

   @Query("SELECT tbl FROM photo_annonce tbl")
   Page<PhotoAnnonce> findAll(Pageable pageable);

}
