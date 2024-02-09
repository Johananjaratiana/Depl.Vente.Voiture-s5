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
@Entity(name="v_landing_page")
public class V_landing_page {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nb_utilisateurs")
    private Long NbUtilisateurs;

    @Column(name="nb_vendues")
    private Long NbVendues;

    @Column(name="nb_annonces")
    private Long NbAnnonces;


    // Constructors, getters, setters

}
