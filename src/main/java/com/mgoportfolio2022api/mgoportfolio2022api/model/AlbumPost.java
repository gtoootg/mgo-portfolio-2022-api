package com.mgoportfolio2022api.mgoportfolio2022api.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="photoalbum-post")
public class AlbumPost {

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


    public AlbumPost() {
        // Default constructor required by Hibernate
    }

    public AlbumPost(int id, String title, String description, String country, BigDecimal lat, BigDecimal lng){
        this.id=id;
        this.title=title;
        this.description=description;
        this.country=country;
        this.lat=lat;
        this.lng=lng;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

    public BigDecimal getLng() {
        return lng;
    }

    public void setLng(BigDecimal lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "AlbumPost{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", country='" + country + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
