package com.vente.voiture.crud.repository;

import com.vente.voiture.crud.model.Couleur;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouleurRepository extends JpaRepository<Couleur, Long> {
 }
