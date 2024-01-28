package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.AnnonceFavoris;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceFavorisRepository extends JpaRepository<AnnonceFavoris, Long> {
    @Query("SELECT pa FROM annonce_favoris pa WHERE pa.IdAnnonce = ?1")
   List<AnnonceFavoris> findByIdAnnonce(Integer IdAnnonce);

   @Query("SELECT pa FROM annonce_favoris pa WHERE pa.IdUsers = ?1")
   List<AnnonceFavoris> findByIdUsers(Integer IdUsers);

}
