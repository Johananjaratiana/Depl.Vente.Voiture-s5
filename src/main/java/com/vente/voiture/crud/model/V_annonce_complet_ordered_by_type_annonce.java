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
@Entity(name="v_annonce_complet_ordered_by_type_annonce")
public class V_annonce_complet_ordered_by_type_annonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="km_effectue")
    private Double KmEffectue;

    @Column(name="nom_users")
    private String NomUsers;

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

    @Column(name="email_users")
    private String EmailUsers;

    @Column(name="description")
    private String Description;

    @Column(name="nom_couleur")
    private String NomCouleur;

    @Column(name="etat_suspension")
    private Integer EtatSuspension;

    @Column(name="etat_pneu")
    private Integer EtatPneu;

    @Column(name="etat_electronique")
    private Integer EtatElectronique;

    @Column(name="prenom_users")
    private String PrenomUsers;

    @Column(name="rgb_couleur")
    private String RgbCouleur;

    @Column(name="etat_siege")
    private Integer EtatSiege;

    @Column(name="consommation")
    private Double Consommation;

    @Column(name="etat_moteur")
    private Integer EtatMoteur;

    @Column(name="nom_taille")
    private String NomTaille;

    @Column(name="id_taille")
    private Integer IdTaille;

    @Column(name="niveau_type_annonce")
    private Integer NiveauTypeAnnonce;

    @Column(name="nb_place")
    private Integer NbPlace;

    @Column(name="nom_marque")
    private String NomMarque;

    @Column(name="nom_transmission")
    private String NomTransmission;

    @Column(name="nom_energie")
    private String NomEnergie;

    @Column(name="id_users")
    private Integer IdUsers;

    @Column(name="etat_freinage")
    private Integer EtatFreinage;

    @Column(name="nom_type_annonce")
    private String NomTypeAnnonce;

    @Column(name="nom_type_moteur")
    private String NomTypeMoteur;

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

    @Column(name="etat_transmission")
    private Integer EtatTransmission;

    @Column(name="nb_vitesse")
    private Integer NbVitesse;

    @Column(name="nom_modele")
    private String NomModele;

    @Column(name="commission_type_annonce")
    private Double CommissionTypeAnnonce;

    @Column(name="nom_usage")
    private String NomUsage;

    @Column(name="id_couleur")
    private Integer IdCouleur;

    @Column(name="etat_carrosserie")
    private Integer EtatCarrosserie;

    @Column(name="etat_tableau_bord")
    private Integer EtatTableauBord;

    @Column(name="id_type_annonce")
    private Integer IdTypeAnnonce;

    @Column(name="telephone_users")
    private String TelephoneUsers;

    @Column(name="status")
    private Integer Status;


    // Constructors, getters, setters

}
