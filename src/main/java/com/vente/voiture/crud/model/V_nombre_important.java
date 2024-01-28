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
@Entity(name="v_nombre_important")
public class V_nombre_important {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="total_commission")
    private Double TotalCommission;

    @Column(name="nb_annonce_vendu")
    private Long NbAnnonceVendu;

    @Column(name="nb_annonce_valide")
    private Long NbAnnonceValide;

    @Column(name="nb_annonces")
    private Long NbAnnonces;

    @Column(name="nb_annonce_en_attente")
    private Long NbAnnonceEnAttente;

    @Column(name="nb_users")
    private Long NbUsers;

    @Column(name="nb_annonce_rejete")
    private Long NbAnnonceRejete;


    // Constructors, getters, setters

}
