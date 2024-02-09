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
@Entity(name="annonce")
public class Annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nb_place")
    private Integer NbPlace;

    @Column(name="km_effectue")
    private Double KmEffectue;

    @Column(name="id_modele")
    private Integer IdModele;

    @Column(name="id_marque")
    private Integer IdMarque;

    @Column(name="numero")
    private String Numero;

    @Column(name="id_type_moteur")
    private Integer IdTypeMoteur;

    @Column(name="date_annonce")
    private java.sql.Date DateAnnonce;

    @Column(name="description")
    private String Description;

    @Column(name="id_users")
    private Integer IdUsers;

    @Column(name="version")
    private String Version;

    @Column(name="prix_vente")
    private Double PrixVente;

    @Column(name="id_energie")
    private Integer IdEnergie;

    @Column(name="id_transmission")
    private Integer IdTransmission;

    @Column(name="id_usage")
    private Integer IdUsage;

    @Column(name="puissance")
    private Integer Puissance;

    @Column(name="consommation")
    private Double Consommation;

    @Column(name="nb_vitesse")
    private Integer NbVitesse;

    @Column(name="id_couleur")
    private Integer IdCouleur;

    @Column(name="id_taille")
    private Integer IdTaille;

    @Column(name="id_type_annonce")
    private Integer IdTypeAnnonce;

    @Column(name="status")
    private Integer Status;


    // Constructors, getters, setters

}
