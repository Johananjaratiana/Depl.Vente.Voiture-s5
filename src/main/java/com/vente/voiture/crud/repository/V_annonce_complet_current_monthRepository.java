package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_annonce_complet_current_month;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_annonce_complet_current_monthRepository extends JpaRepository<V_annonce_complet_current_month, Long> {
    @Query("SELECT tbl FROM v_annonce_complet_current_month tbl WHERE tbl.IdModele = ?1")
   Page<V_annonce_complet_current_month> findByIdModele(Integer IdModele, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_current_month tbl WHERE tbl.IdMarque = ?1")
   Page<V_annonce_complet_current_month> findByIdMarque(Integer IdMarque, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_current_month tbl WHERE tbl.IdTypeMoteur = ?1")
   Page<V_annonce_complet_current_month> findByIdTypeMoteur(Integer IdTypeMoteur, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_current_month tbl WHERE tbl.IdTaille = ?1")
   Page<V_annonce_complet_current_month> findByIdTaille(Integer IdTaille, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_current_month tbl WHERE tbl.IdUsers = ?1")
   Page<V_annonce_complet_current_month> findByIdUsers(Integer IdUsers, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_current_month tbl WHERE tbl.IdEnergie = ?1")
   Page<V_annonce_complet_current_month> findByIdEnergie(Integer IdEnergie, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_current_month tbl WHERE tbl.IdTransmission = ?1")
   Page<V_annonce_complet_current_month> findByIdTransmission(Integer IdTransmission, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_current_month tbl WHERE tbl.IdUsage = ?1")
   Page<V_annonce_complet_current_month> findByIdUsage(Integer IdUsage, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_current_month tbl WHERE tbl.IdCouleur = ?1")
   Page<V_annonce_complet_current_month> findByIdCouleur(Integer IdCouleur, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_current_month tbl WHERE tbl.IdTypeAnnonce = ?1")
   Page<V_annonce_complet_current_month> findByIdTypeAnnonce(Integer IdTypeAnnonce, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet_current_month tbl")
   Page<V_annonce_complet_current_month> findAll(Pageable pageable);

}
