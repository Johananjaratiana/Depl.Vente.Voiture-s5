package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_annonce_complet_ordered_by_type_annonce;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_annonce_complet_ordered_by_type_annonceRepository extends JpaRepository<V_annonce_complet_ordered_by_type_annonce, Long> {
    @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl WHERE tbl.IdModele = ?1")
   Page<V_annonce_complet_ordered_by_type_annonce> findByIdModele(Integer IdModele, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl WHERE tbl.IdMarque = ?1")
   Page<V_annonce_complet_ordered_by_type_annonce> findByIdMarque(Integer IdMarque, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl WHERE tbl.IdTypeMoteur = ?1")
   Page<V_annonce_complet_ordered_by_type_annonce> findByIdTypeMoteur(Integer IdTypeMoteur, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl WHERE tbl.IdTaille = ?1")
   Page<V_annonce_complet_ordered_by_type_annonce> findByIdTaille(Integer IdTaille, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl WHERE tbl.IdUsers = ?1")
   Page<V_annonce_complet_ordered_by_type_annonce> findByIdUsers(Integer IdUsers, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl WHERE tbl.IdEnergie = ?1")
   Page<V_annonce_complet_ordered_by_type_annonce> findByIdEnergie(Integer IdEnergie, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl WHERE tbl.IdTransmission = ?1")
   Page<V_annonce_complet_ordered_by_type_annonce> findByIdTransmission(Integer IdTransmission, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl WHERE tbl.IdUsage = ?1")
   Page<V_annonce_complet_ordered_by_type_annonce> findByIdUsage(Integer IdUsage, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl WHERE tbl.IdCouleur = ?1")
   Page<V_annonce_complet_ordered_by_type_annonce> findByIdCouleur(Integer IdCouleur, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl WHERE tbl.IdTypeAnnonce = ?1")
   Page<V_annonce_complet_ordered_by_type_annonce> findByIdTypeAnnonce(Integer IdTypeAnnonce, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_ordered_by_type_annonce tbl")
   Page<V_annonce_complet_ordered_by_type_annonce> findAll(Pageable pageable);

}
