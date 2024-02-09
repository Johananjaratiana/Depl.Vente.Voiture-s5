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
@Entity(name="v_stat_annonce_vendu_par_marque")
public class V_stat_annonce_vendu_par_marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nom_marque")
    private String NomMarque;

    @Column(name="id_marque")
    private Integer IdMarque;

    @Column(name="nb_annonce_vendu")
    private Long NbAnnonceVendu;


    // Constructors, getters, setters

}
