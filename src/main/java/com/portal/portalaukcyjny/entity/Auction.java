package com.portal.portalaukcyjny.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "auction")
@Getter
@Setter
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "active")
    private Integer active;

    @Column(name = "title", length = 45)
    private String title;

    @Column(name = "date_posted", nullable = false)
    private Instant datePosted;

    @Column(name = "main_image", length = 45)
    private String mainImage;

    @Column(name = "image1", length = 45)
    private String image1;

    @Column(name = "image2", length = 45)
    private String image2;

    @Column(name = "price", nullable = false)
    private Double price;

    @Column(name = "buyer_id")
    private Integer buyerId;

    @Column(name = "info", nullable = false, length = 500)
    private String info;

    @Column(name = "state", nullable = false, length = 45)
    private String state;

    @Column(name = "delivery", nullable = false)
    private Integer delivery;

    @Column(name = "pickup", nullable = false)
    private Integer pickup;

    @Column(name = "itemSent", nullable = false)
    private Integer itemSent;
}