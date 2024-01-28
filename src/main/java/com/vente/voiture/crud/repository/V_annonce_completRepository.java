package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_annonce_complet;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_annonce_completRepository extends JpaRepository<V_annonce_complet, Long> {
    @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.IdModele = ?1")
   List<V_annonce_complet> findByIdModele(Integer IdModele);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.IdMarque = ?1")
   List<V_annonce_complet> findByIdMarque(Integer IdMarque);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.IdTypeMoteur = ?1")
   List<V_annonce_complet> findByIdTypeMoteur(Integer IdTypeMoteur);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.IdTaille = ?1")
   List<V_annonce_complet> findByIdTaille(Integer IdTaille);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.IdUsers = ?1")
   List<V_annonce_complet> findByIdUsers(Integer IdUsers);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.IdEnergie = ?1")
   List<V_annonce_complet> findByIdEnergie(Integer IdEnergie);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.IdTransmission = ?1")
   List<V_annonce_complet> findByIdTransmission(Integer IdTransmission);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.IdUsage = ?1")
   List<V_annonce_complet> findByIdUsage(Integer IdUsage);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.IdCouleur = ?1")
   List<V_annonce_complet> findByIdCouleur(Integer IdCouleur);

   @Query("SELECT pa FROM v_annonce_complet pa WHERE pa.IdTypeAnnonce = ?1")
   List<V_annonce_complet> findByIdTypeAnnonce(Integer IdTypeAnnonce);

}
