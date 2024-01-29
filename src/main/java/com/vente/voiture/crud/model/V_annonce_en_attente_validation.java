package com.vente.voiture.crud.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity(name="v_annonce_en_attente_validation")
public class V_annonce_en_attente_validation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="voiture")
    private String Voiture;

    @Column(name="utilisateur")
    private String Utilisateur;

    @Column(name="date_annonce")
    private java.sql.Date DateAnnonce;

    @Column(name="description")
    private String Description;

    @Column(name="prix_vente")
    private Double PrixVente;


    // Constructors, getters, setters

}
