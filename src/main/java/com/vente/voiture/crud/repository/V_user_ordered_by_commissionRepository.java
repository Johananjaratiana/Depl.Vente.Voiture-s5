package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_user_ordered_by_commission;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_user_ordered_by_commissionRepository extends JpaRepository<V_user_ordered_by_commission, Long> {
    @Query("SELECT pa FROM v_user_ordered_by_commission pa WHERE pa.Idprofile = ?1")
   List<V_user_ordered_by_commission> findByIdprofile(Integer Idprofile);

}
