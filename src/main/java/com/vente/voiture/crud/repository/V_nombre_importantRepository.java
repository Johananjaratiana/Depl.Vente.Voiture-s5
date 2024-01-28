package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_nombre_important;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_nombre_importantRepository extends JpaRepository<V_nombre_important, Long> {
    @Query("SELECT pa FROM v_nombre_important pa WHERE pa.NbAnnonceValide = ?1")
   List<V_nombre_important> findByNbAnnonceValide(Integer NbAnnonceValide);

}
