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
@Entity(name="v_stat_current_year")
public class V_stat_current_year {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nb_annonce")
    private Long NbAnnonce;

    @Column(name="nb_annonce_vendu")
    private Long NbAnnonceVendu;

    @Column(name="year")
    private Object Year;

    @Column(name="prix_mois_actuelle")
    private Double PrixMoisActuelle;

    @Column(name="commission_mois_actuelle")
    private Double CommissionMoisActuelle;


    // Constructors, getters, setters

}
