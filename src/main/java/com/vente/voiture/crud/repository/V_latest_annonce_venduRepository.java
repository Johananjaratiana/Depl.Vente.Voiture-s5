package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_latest_annonce_vendu;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_latest_annonce_venduRepository extends JpaRepository<V_latest_annonce_vendu, Long> {
    @Query("SELECT tbl FROM v_latest_annonce_vendu tbl WHERE tbl.IdTypeMoteur = ?1")
   Page<V_latest_annonce_vendu> findByIdTypeMoteur(Integer IdTypeMoteur, Pageable pageable);

   @Query("SELECT tbl FROM v_latest_annonce_vendu tbl WHERE tbl.IdTaille = ?1")
   Page<V_latest_annonce_vendu> findByIdTaille(Integer IdTaille, Pageable pageable);

   @Query("SELECT tbl FROM v_latest_annonce_vendu tbl WHERE tbl.IdTransmission = ?1")
   Page<V_latest_annonce_vendu> findByIdTransmission(Integer IdTransmission, Pageable pageable);

   @Query("SELECT tbl FROM v_latest_annonce_vendu tbl WHERE tbl.IdCouleur = ?1")
   Page<V_latest_annonce_vendu> findByIdCouleur(Integer IdCouleur, Pageable pageable);

   @Query("SELECT tbl FROM v_latest_annonce_vendu tbl WHERE tbl.IdTypeAnnonce = ?1")
   Page<V_latest_annonce_vendu> findByIdTypeAnnonce(Integer IdTypeAnnonce, Pageable pageable);

   @Query("SELECT tbl FROM v_latest_annonce_vendu tbl WHERE tbl.IdModele = ?1")
   Page<V_latest_annonce_vendu> findByIdModele(Integer IdModele, Pageable pageable);

   @Query("SELECT tbl FROM v_latest_annonce_vendu tbl WHERE tbl.IdMarque = ?1")
   Page<V_latest_annonce_vendu> findByIdMarque(Integer IdMarque, Pageable pageable);

   @Query("SELECT tbl FROM v_latest_annonce_vendu tbl WHERE tbl.IdUsers = ?1")
   Page<V_latest_annonce_vendu> findByIdUsers(Integer IdUsers, Pageable pageable);

   @Query("SELECT tbl FROM v_latest_annonce_vendu tbl WHERE tbl.IdEnergie = ?1")
   Page<V_latest_annonce_vendu> findByIdEnergie(Integer IdEnergie, Pageable pageable);

   @Query("SELECT tbl FROM v_latest_annonce_vendu tbl WHERE tbl.IdUsage = ?1")
   Page<V_latest_annonce_vendu> findByIdUsage(Integer IdUsage, Pageable pageable);

   @Query("SELECT tbl FROM v_latest_annonce_vendu tbl")
   Page<V_latest_annonce_vendu> findAll(Pageable pageable);

}
