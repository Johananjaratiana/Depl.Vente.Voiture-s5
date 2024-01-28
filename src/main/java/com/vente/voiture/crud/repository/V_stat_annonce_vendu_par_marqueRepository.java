package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_stat_annonce_vendu_par_marque;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_stat_annonce_vendu_par_marqueRepository extends JpaRepository<V_stat_annonce_vendu_par_marque, Long> {
    @Query("SELECT pa FROM v_stat_annonce_vendu_par_marque pa WHERE pa.IdMarque = ?1")
   List<V_stat_annonce_vendu_par_marque> findByIdMarque(Integer IdMarque);

}
