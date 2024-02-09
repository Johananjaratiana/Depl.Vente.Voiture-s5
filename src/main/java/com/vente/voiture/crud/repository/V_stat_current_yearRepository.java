package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_stat_current_year;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_stat_current_yearRepository extends JpaRepository<V_stat_current_year, Long> {
    @Query("SELECT tbl FROM v_stat_current_year tbl")
   Page<V_stat_current_year> findAll(Pageable pageable);

}
