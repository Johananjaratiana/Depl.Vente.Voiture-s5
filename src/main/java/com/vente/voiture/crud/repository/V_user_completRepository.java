package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_user_complet;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_user_completRepository extends JpaRepository<V_user_complet, Long> {
    @Query("SELECT pa FROM v_user_complet pa WHERE pa.Idprofile = ?1")
   List<V_user_complet> findByIdprofile(Integer Idprofile);

}
