package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_stat_current_year;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_stat_current_yearRepository extends JpaRepository<V_stat_current_year, Long> {
 }
