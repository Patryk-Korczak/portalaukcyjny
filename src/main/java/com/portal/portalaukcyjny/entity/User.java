package com.portal.portalaukcyjny.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "email")
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Column(name = "salt")
    private String salt;

    @Column(name = "wallet_balance")
    private Double walletBalance;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "home_number")
    private String homeNumber;

    @Column(name = "login")
    private String login;

    @Column(name = "postal_number")
    private String postalNumber;

    @Column(name = "role")
    private String role;

    @Column(name = "street_name")
    private String streetName;

    @Column(name = "surname")
    private String surname;
}