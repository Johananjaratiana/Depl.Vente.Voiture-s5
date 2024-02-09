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
@Entity(name="annonce_favoris")
public class AnnonceFavoris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="id_annonce")
    private Integer IdAnnonce;

    @Column(name="id_users")
    private Integer IdUsers;

    @Column(name="status")
    private Integer Status;


    // Constructors, getters, setters

}
