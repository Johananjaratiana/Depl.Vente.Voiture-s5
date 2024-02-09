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
@Entity(name="v_user_ordered_by_commission")
public class V_user_ordered_by_commission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="mdp")
    private String Mdp;

    @Column(name="addresse")
    private String Addresse;

    @Column(name="telephone")
    private String Telephone;

    @Column(name="commission")
    private Double Commission;

    @Column(name="idprofile")
    private Integer Idprofile;

    @Column(name="nom")
    private String Nom;

    @Column(name="prenom")
    private String Prenom;

    @Column(name="email")
    private String Email;

    @Column(name="dtn")
    private java.sql.Date Dtn;


    // Constructors, getters, setters

}
