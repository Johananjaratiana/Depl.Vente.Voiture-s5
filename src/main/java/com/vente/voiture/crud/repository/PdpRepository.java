package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Pdp;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PdpRepository extends JpaRepository<Pdp, Long> {
    @Query("SELECT pa FROM pdp pa WHERE pa.IdUsers = ?1")
   List<Pdp> findByIdUsers(Integer IdUsers);

}
