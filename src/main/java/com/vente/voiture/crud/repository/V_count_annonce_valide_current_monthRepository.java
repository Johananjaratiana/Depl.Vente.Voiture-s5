package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_count_annonce_valide_current_month;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_count_annonce_valide_current_monthRepository extends JpaRepository<V_count_annonce_valide_current_month, Long> {
    @Query("SELECT pa FROM v_count_annonce_valide_current_month pa WHERE pa.NbAnnonceValide = ?1")
   List<V_count_annonce_valide_current_month> findByNbAnnonceValide(Integer NbAnnonceValide);

}
