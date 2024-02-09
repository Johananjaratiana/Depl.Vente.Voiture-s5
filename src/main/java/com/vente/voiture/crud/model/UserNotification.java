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
@Entity(name="user_notification")
public class UserNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="id_users")
    private Integer IdUsers;

    @Column(name="token")
    private String Token;


    // Constructors, getters, setters

}
