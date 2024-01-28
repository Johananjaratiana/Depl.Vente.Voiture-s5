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
@Entity(name="type_annonce")
public class TypeAnnonce {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="commission")
    private Double Commission;

    @Column(name="nom")
    private String Nom;

    @Column(name="niveau")
    private Integer Niveau;

    @Column(name="status")
    private Integer Status;


    // Constructors, getters, setters

}
