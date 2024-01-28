package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_best_user;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_best_userRepository extends JpaRepository<V_best_user, Long> {
    @Query("SELECT pa FROM v_best_user pa WHERE pa.Idprofile = ?1")
   List<V_best_user> findByIdprofile(Integer Idprofile);

}
