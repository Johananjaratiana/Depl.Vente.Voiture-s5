package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.EtatAnnonce;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtatAnnonceRepository extends JpaRepository<EtatAnnonce, Long> {
    @Query("SELECT pa FROM etat_annonce pa WHERE pa.IdAnnonce = ?1")
   List<EtatAnnonce> findByIdAnnonce(Integer IdAnnonce);

}
