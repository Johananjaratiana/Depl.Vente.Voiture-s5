package com.vente.voiture.crud.model;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;

@Getter
@Setter
@Entity(name="etat_annonce")
public class EtatAnnonce {
    @Id
    private Long id;

    @Column(name="id_annonce")
    private Integer IdAnnonce;

    @Column(name="electronique")
    private Integer Electronique;

    @Column(name="moteur")
    private Integer Moteur;

    @Column(name="carrosserie")
    private Integer Carrosserie;

    @Column(name="freinage")
    private Integer Freinage;

    @Column(name="transmission")
    private Integer Transmission;

    @Column(name="siege")
    private Integer Siege;

    @Column(name="tableau_bord")
    private Integer TableauBord;

    @Column(name="pneu")
    private Integer Pneu;

    @Column(name="suspension")
    private Integer Suspension;


    // Constructors, getters, setters

}
