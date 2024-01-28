package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Usage;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsageRepository extends JpaRepository<Usage, Long> {
 }
