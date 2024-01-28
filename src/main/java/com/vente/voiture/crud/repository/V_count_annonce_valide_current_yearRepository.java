package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_count_annonce_valide_current_year;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_count_annonce_valide_current_yearRepository extends JpaRepository<V_count_annonce_valide_current_year, Long> {
    @Query("SELECT pa FROM v_count_annonce_valide_current_year pa WHERE pa.NbAnnonceValide = ?1")
   List<V_count_annonce_valide_current_year> findByNbAnnonceValide(Integer NbAnnonceValide);

}
