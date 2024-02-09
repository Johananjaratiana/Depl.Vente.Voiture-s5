package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.TypeAnnonce;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeAnnonceRepository extends JpaRepository<TypeAnnonce, Long> {
    @Query("SELECT tbl FROM type_annonce tbl")
   Page<TypeAnnonce> findAll(Pageable pageable);

}
