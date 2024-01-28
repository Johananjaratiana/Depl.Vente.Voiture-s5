package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_latest_annonce_vendu;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_latest_annonce_venduRepository extends JpaRepository<V_latest_annonce_vendu, Long> {
    @Query("SELECT pa FROM v_latest_annonce_vendu pa WHERE pa.IdTypeMoteur = ?1")
   List<V_latest_annonce_vendu> findByIdTypeMoteur(Integer IdTypeMoteur);

   @Query("SELECT pa FROM v_latest_annonce_vendu pa WHERE pa.IdTaille = ?1")
   List<V_latest_annonce_vendu> findByIdTaille(Integer IdTaille);

   @Query("SELECT pa FROM v_latest_annonce_vendu pa WHERE pa.IdTransmission = ?1")
   List<V_latest_annonce_vendu> findByIdTransmission(Integer IdTransmission);

   @Query("SELECT pa FROM v_latest_annonce_vendu pa WHERE pa.IdCouleur = ?1")
   List<V_latest_annonce_vendu> findByIdCouleur(Integer IdCouleur);

   @Query("SELECT pa FROM v_latest_annonce_vendu pa WHERE pa.IdTypeAnnonce = ?1")
   List<V_latest_annonce_vendu> findByIdTypeAnnonce(Integer IdTypeAnnonce);

   @Query("SELECT pa FROM v_latest_annonce_vendu pa WHERE pa.IdModele = ?1")
   List<V_latest_annonce_vendu> findByIdModele(Integer IdModele);

   @Query("SELECT pa FROM v_latest_annonce_vendu pa WHERE pa.IdMarque = ?1")
   List<V_latest_annonce_vendu> findByIdMarque(Integer IdMarque);

   @Query("SELECT pa FROM v_latest_annonce_vendu pa WHERE pa.IdUsers = ?1")
   List<V_latest_annonce_vendu> findByIdUsers(Integer IdUsers);

   @Query("SELECT pa FROM v_latest_annonce_vendu pa WHERE pa.IdEnergie = ?1")
   List<V_latest_annonce_vendu> findByIdEnergie(Integer IdEnergie);

   @Query("SELECT pa FROM v_latest_annonce_vendu pa WHERE pa.IdUsage = ?1")
   List<V_latest_annonce_vendu> findByIdUsage(Integer IdUsage);

}
