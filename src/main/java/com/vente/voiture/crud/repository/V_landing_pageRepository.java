package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_landing_page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_landing_pageRepository extends JpaRepository<V_landing_page, Long> {
    @Query("SELECT tbl FROM v_landing_page tbl")
   Page<V_landing_page> findAll(Pageable pageable);

}
