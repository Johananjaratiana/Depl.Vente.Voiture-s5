package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_stat_by_month;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_stat_by_monthRepository extends JpaRepository<V_stat_by_month, Long> {
    @Query("SELECT tbl FROM v_stat_by_month tbl")
   Page<V_stat_by_month> findAll(Pageable pageable);

}
