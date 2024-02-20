package com.mgoportfolio2022api.mgoportfolio2022api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name="album_post")
@Data
public class AlbumPostEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;

    @Column(name="title", length=45,nullable = false)
    private String title;

    @Column(name="description", length=2000,nullable = false)
    private String description;

    @Column(name="country", length=45,nullable = false)
    private  String country;

    @Column(name="lat",nullable = false)
    private BigDecimal lat;

    @Column(name="lng",nullable = false )
    private BigDecimal lng;

    @Column(name="user_id", nullable = false)
    private int userId;
}
