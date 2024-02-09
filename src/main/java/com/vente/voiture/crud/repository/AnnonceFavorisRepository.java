package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.AnnonceFavoris;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceFavorisRepository extends JpaRepository<AnnonceFavoris, Long> {
    @Query("SELECT tbl FROM annonce_favoris tbl WHERE tbl.IdAnnonce = ?1")
   Page<AnnonceFavoris> findByIdAnnonce(Integer IdAnnonce, Pageable pageable);

   @Query("SELECT tbl FROM annonce_favoris tbl WHERE tbl.IdUsers = ?1")
   Page<AnnonceFavoris> findByIdUsers(Integer IdUsers, Pageable pageable);

   @Query("SELECT tbl FROM annonce_favoris tbl")
   Page<AnnonceFavoris> findAll(Pageable pageable);


   @Query(value =   "SELECT tbl.* FROM annonce_favoris tbl " +
                    "   WHERE tbl.id_annonce = :idAnnonce " +
                    "   AND tbl.id_users = :idUsers ", nativeQuery = true)
   List<AnnonceFavoris> findByIdAnnonceAndIdUsers(Long idAnnonce, Long idUsers);

}
