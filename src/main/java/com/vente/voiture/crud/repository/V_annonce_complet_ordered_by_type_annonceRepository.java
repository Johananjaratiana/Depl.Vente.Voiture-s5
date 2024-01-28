package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_annonce_complet_ordered_by_type_annonce;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_annonce_complet_ordered_by_type_annonceRepository extends JpaRepository<V_annonce_complet_ordered_by_type_annonce, Long> {
    @Query("SELECT pa FROM v_annonce_complet_ordered_by_type_annonce pa WHERE pa.IdModele = ?1")
   List<V_annonce_complet_ordered_by_type_annonce> findByIdModele(Integer IdModele);

   @Query("SELECT pa FROM v_annonce_complet_ordered_by_type_annonce pa WHERE pa.IdMarque = ?1")
   List<V_annonce_complet_ordered_by_type_annonce> findByIdMarque(Integer IdMarque);

   @Query("SELECT pa FROM v_annonce_complet_ordered_by_type_annonce pa WHERE pa.IdTypeMoteur = ?1")
   List<V_annonce_complet_ordered_by_type_annonce> findByIdTypeMoteur(Integer IdTypeMoteur);

   @Query("SELECT pa FROM v_annonce_complet_ordered_by_type_annonce pa WHERE pa.IdTaille = ?1")
   List<V_annonce_complet_ordered_by_type_annonce> findByIdTaille(Integer IdTaille);

   @Query("SELECT pa FROM v_annonce_complet_ordered_by_type_annonce pa WHERE pa.IdUsers = ?1")
   List<V_annonce_complet_ordered_by_type_annonce> findByIdUsers(Integer IdUsers);

   @Query("SELECT pa FROM v_annonce_complet_ordered_by_type_annonce pa WHERE pa.IdEnergie = ?1")
   List<V_annonce_complet_ordered_by_type_annonce> findByIdEnergie(Integer IdEnergie);

   @Query("SELECT pa FROM v_annonce_complet_ordered_by_type_annonce pa WHERE pa.IdTransmission = ?1")
   List<V_annonce_complet_ordered_by_type_annonce> findByIdTransmission(Integer IdTransmission);

   @Query("SELECT pa FROM v_annonce_complet_ordered_by_type_annonce pa WHERE pa.IdUsage = ?1")
   List<V_annonce_complet_ordered_by_type_annonce> findByIdUsage(Integer IdUsage);

   @Query("SELECT pa FROM v_annonce_complet_ordered_by_type_annonce pa WHERE pa.IdCouleur = ?1")
   List<V_annonce_complet_ordered_by_type_annonce> findByIdCouleur(Integer IdCouleur);

   @Query("SELECT pa FROM v_annonce_complet_ordered_by_type_annonce pa WHERE pa.IdTypeAnnonce = ?1")
   List<V_annonce_complet_ordered_by_type_annonce> findByIdTypeAnnonce(Integer IdTypeAnnonce);

}
