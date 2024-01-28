package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.PhotoAnnonce;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhotoAnnonceRepository extends JpaRepository<PhotoAnnonce, Long> {
    @Query("SELECT pa FROM photo_annonce pa WHERE pa.IdAnnonce = ?1")
   List<PhotoAnnonce> findByIdAnnonce(Integer IdAnnonce);

}
