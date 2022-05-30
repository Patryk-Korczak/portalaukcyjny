package com.portal.portalaukcyjny.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reports")
@Getter
@Setter
public class Report {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "reporter_id", nullable = false)
    private Integer reporterId;

    @Column(name = "reported_auction_id", nullable = false)
    private Integer reportedAuctionId;

    @Column(name = "information", length = 500)
    private String information;

    @Column(name = "resolved")
    private Integer resolved;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resolving_admin_id")
    private Admin resolvingAdmin;

    @Column(name = "admin_comment", length = 500)
    private String adminComment;

    @Column(name = "action_taken", length = 45)
    private String actionTaken;
}