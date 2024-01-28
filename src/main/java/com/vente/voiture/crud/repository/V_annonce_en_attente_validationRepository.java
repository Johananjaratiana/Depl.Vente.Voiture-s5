package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.V_annonce_en_attente_validation;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface V_annonce_en_attente_validationRepository extends JpaRepository<V_annonce_en_attente_validation, Long> {
 }
