package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Annonce;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
    @Query("SELECT pa FROM annonce pa WHERE pa.IdModele = ?1")
   List<Annonce> findByIdModele(Integer IdModele);

   @Query("SELECT pa FROM annonce pa WHERE pa.IdMarque = ?1")
   List<Annonce> findByIdMarque(Integer IdMarque);

   @Query("SELECT pa FROM annonce pa WHERE pa.IdTypeMoteur = ?1")
   List<Annonce> findByIdTypeMoteur(Integer IdTypeMoteur);

   @Query("SELECT pa FROM annonce pa WHERE pa.IdUsers = ?1")
   List<Annonce> findByIdUsers(Integer IdUsers);

   @Query("SELECT pa FROM annonce pa WHERE pa.IdEnergie = ?1")
   List<Annonce> findByIdEnergie(Integer IdEnergie);

   @Query("SELECT pa FROM annonce pa WHERE pa.IdTransmission = ?1")
   List<Annonce> findByIdTransmission(Integer IdTransmission);

   @Query("SELECT pa FROM annonce pa WHERE pa.IdUsage = ?1")
   List<Annonce> findByIdUsage(Integer IdUsage);

   @Query("SELECT pa FROM annonce pa WHERE pa.IdCouleur = ?1")
   List<Annonce> findByIdCouleur(Integer IdCouleur);

   @Query("SELECT pa FROM annonce pa WHERE pa.IdTaille = ?1")
   List<Annonce> findByIdTaille(Integer IdTaille);

   @Query("SELECT pa FROM annonce pa WHERE pa.IdTypeAnnonce = ?1")
   List<Annonce> findByIdTypeAnnonce(Integer IdTypeAnnonce);

}
