package com.mgoportfolio2022api.mgoportfolio2022api.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="album_category")
@Data
public class AlbumCategoryEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id", nullable = false)
    private int id;

    @Column(name="category_id",nullable = false)
    private long categoryId;


    @ManyToOne
    @JoinColumn(name = "album_image_id")
    private AlbumImageEntity savedAlbumImageEntity;
}
