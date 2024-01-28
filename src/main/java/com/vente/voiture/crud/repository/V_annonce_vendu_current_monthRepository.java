package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_annonce_vendu_current_month;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_annonce_vendu_current_monthRepository extends JpaRepository<V_annonce_vendu_current_month, Long> {
    @Query("SELECT pa FROM v_annonce_vendu_current_month pa WHERE pa.IdTypeMoteur = ?1")
   List<V_annonce_vendu_current_month> findByIdTypeMoteur(Integer IdTypeMoteur);

   @Query("SELECT pa FROM v_annonce_vendu_current_month pa WHERE pa.IdTaille = ?1")
   List<V_annonce_vendu_current_month> findByIdTaille(Integer IdTaille);

   @Query("SELECT pa FROM v_annonce_vendu_current_month pa WHERE pa.IdTransmission = ?1")
   List<V_annonce_vendu_current_month> findByIdTransmission(Integer IdTransmission);

   @Query("SELECT pa FROM v_annonce_vendu_current_month pa WHERE pa.IdCouleur = ?1")
   List<V_annonce_vendu_current_month> findByIdCouleur(Integer IdCouleur);

   @Query("SELECT pa FROM v_annonce_vendu_current_month pa WHERE pa.IdTypeAnnonce = ?1")
   List<V_annonce_vendu_current_month> findByIdTypeAnnonce(Integer IdTypeAnnonce);

   @Query("SELECT pa FROM v_annonce_vendu_current_month pa WHERE pa.IdModele = ?1")
   List<V_annonce_vendu_current_month> findByIdModele(Integer IdModele);

   @Query("SELECT pa FROM v_annonce_vendu_current_month pa WHERE pa.IdMarque = ?1")
   List<V_annonce_vendu_current_month> findByIdMarque(Integer IdMarque);

   @Query("SELECT pa FROM v_annonce_vendu_current_month pa WHERE pa.IdUsers = ?1")
   List<V_annonce_vendu_current_month> findByIdUsers(Integer IdUsers);

   @Query("SELECT pa FROM v_annonce_vendu_current_month pa WHERE pa.IdEnergie = ?1")
   List<V_annonce_vendu_current_month> findByIdEnergie(Integer IdEnergie);

   @Query("SELECT pa FROM v_annonce_vendu_current_month pa WHERE pa.IdUsage = ?1")
   List<V_annonce_vendu_current_month> findByIdUsage(Integer IdUsage);

}
