package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_annonce_complet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_annonce_completRepository extends JpaRepository<V_annonce_complet, Long> {
    @Query("SELECT tbl FROM v_annonce_complet tbl WHERE tbl.IdModele = ?1")
   Page<V_annonce_complet> findByIdModele(Integer IdModele, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet tbl WHERE tbl.IdMarque = ?1")
   Page<V_annonce_complet> findByIdMarque(Integer IdMarque, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet tbl WHERE tbl.IdTypeMoteur = ?1")
   Page<V_annonce_complet> findByIdTypeMoteur(Integer IdTypeMoteur, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet tbl WHERE tbl.IdTaille = ?1")
   Page<V_annonce_complet> findByIdTaille(Integer IdTaille, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet tbl WHERE tbl.IdUsers = ?1")
   Page<V_annonce_complet> findByIdUsers(Integer IdUsers, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet tbl WHERE tbl.IdEnergie = ?1")
   Page<V_annonce_complet> findByIdEnergie(Integer IdEnergie, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet tbl WHERE tbl.IdTransmission = ?1")
   Page<V_annonce_complet> findByIdTransmission(Integer IdTransmission, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet tbl WHERE tbl.IdUsage = ?1")
   Page<V_annonce_complet> findByIdUsage(Integer IdUsage, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet tbl WHERE tbl.IdCouleur = ?1")
   Page<V_annonce_complet> findByIdCouleur(Integer IdCouleur, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet tbl WHERE tbl.IdTypeAnnonce = ?1")
   Page<V_annonce_complet> findByIdTypeAnnonce(Integer IdTypeAnnonce, Pageable pageable);

   @Query("SELECT tbl FROM v_annonce_complet tbl")
   Page<V_annonce_complet> findAll(Pageable pageable);

//    ------------------------ STATUS

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.Status = 10")
   Page<V_annonce_complet> findNonVendu(Pageable pageable);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.Status = 0")
   Page<V_annonce_complet> findNonValide(Pageable pageable);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.Status = 20")
   Page<V_annonce_complet> findVendu(Pageable pageable);

//    ------------------------ ANNONCE FAVORIS
   @Query(value =   "SELECT pa FROM v_annonce_complet pa WHERE pa.status = 20 " +
                    " WHERE id IN ( " +
                    "       SELECT string_agg(id_annonce::text, ',') AS id_annonces\n" +
                    "           FROM annonce_favoris\n" +
                    "           WHERE id_users =  :userId " +
                    " ) ", nativeQuery = true)
   Page<V_annonce_complet> findFavorisByUsersId(Integer userId, Pageable pageable);
}
