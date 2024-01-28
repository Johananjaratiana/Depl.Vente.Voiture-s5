package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_count_annonce_vendu_current_month;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_count_annonce_vendu_current_monthRepository extends JpaRepository<V_count_annonce_vendu_current_month, Long> {
 }
