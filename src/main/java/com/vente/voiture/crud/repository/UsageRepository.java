package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Usage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageRepository extends JpaRepository<Usage, Long> {
    @Query("SELECT tbl FROM usage tbl")
   Page<Usage> findAll(Pageable pageable);

}
