package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Annonce;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    @Query("SELECT tbl FROM annonce tbl WHERE tbl.IdModele = ?1")
   Page<Annonce> findByIdModele(Integer IdModele, Pageable pageable);

   @Query("SELECT tbl FROM annonce tbl WHERE tbl.IdMarque = ?1")
   Page<Annonce> findByIdMarque(Integer IdMarque, Pageable pageable);

   @Query("SELECT tbl FROM annonce tbl WHERE tbl.IdTypeMoteur = ?1")
   Page<Annonce> findByIdTypeMoteur(Integer IdTypeMoteur, Pageable pageable);

   @Query("SELECT tbl FROM annonce tbl WHERE tbl.IdUsers = ?1")
   Page<Annonce> findByIdUsers(Integer IdUsers, Pageable pageable);

   @Query("SELECT tbl FROM annonce tbl WHERE tbl.IdEnergie = ?1")
   Page<Annonce> findByIdEnergie(Integer IdEnergie, Pageable pageable);

   @Query("SELECT tbl FROM annonce tbl WHERE tbl.IdTransmission = ?1")
   Page<Annonce> findByIdTransmission(Integer IdTransmission, Pageable pageable);

   @Query("SELECT tbl FROM annonce tbl WHERE tbl.IdUsage = ?1")
   Page<Annonce> findByIdUsage(Integer IdUsage, Pageable pageable);

   @Query("SELECT tbl FROM annonce tbl WHERE tbl.IdCouleur = ?1")
   Page<Annonce> findByIdCouleur(Integer IdCouleur, Pageable pageable);

   @Query("SELECT tbl FROM annonce tbl WHERE tbl.IdTaille = ?1")
   Page<Annonce> findByIdTaille(Integer IdTaille, Pageable pageable);

   @Query("SELECT tbl FROM annonce tbl WHERE tbl.IdTypeAnnonce = ?1")
   Page<Annonce> findByIdTypeAnnonce(Integer IdTypeAnnonce, Pageable pageable);

   @Query("SELECT tbl FROM annonce tbl")
   Page<Annonce> findAll(Pageable pageable);

   @Query(value =   "SELECT tbl FROM annonce_favoris tbl " +
                    "   WHERE tbl.id_annonce = :idAnnonce " +
                    "   AND tbl.id_users = :idUsers ", nativeQuery = true)
   List<Object> findByIdAnnonceAndIdUsers(Long idAnnonce, Long idUsers);
}
