package com.vente.voiture.function.annonce.search;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


public interface AnnonceCompletMaterializedRepository extends JpaRepository<AnnonceCompletMaterializedView, Long> {
    @Query(value = "SELECT tbl.* FROM mv_annonce_complet tbl WHERE " +
        "status =  10 AND " +
        "to_tsvector('french', " +
        "coalesce(tbl.nom_marque, '') || ' ' || " +
        "coalesce(tbl.nom_modele, '') || ' ' || " +
        "coalesce(tbl.description, '') || ' ' || " +
        "coalesce(tbl.nom_users, '') || ' ' || " +
        "coalesce(tbl.nom_transmission, '') || ' ' || " +
        "coalesce(tbl.nom_usage, '') || ' ' || " +
        "coalesce(tbl.nom_taille, '') || ' ' || " +
        "coalesce(tbl.nom_couleur, '') || ' ' || " +
        "coalesce(tbl.nom_type_moteur, '') || ' ' || " +
        "coalesce(tbl.nom_type_annonce, '')" +
        ") @@ plainto_tsquery(:searchTerm)", nativeQuery = true)
    Page<AnnonceCompletMaterializedView> fullTextSearch(@Param("searchTerm") String searchTerm, Pageable pageable);
}


