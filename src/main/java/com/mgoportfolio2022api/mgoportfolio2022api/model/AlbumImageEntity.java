package com.mgoportfolio2022api.mgoportfolio2022api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Table(name="album_image")
@Data
public class AlbumImageEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;
    @Column(name="image_id",nullable = false)
    private BigInteger imageId;

    @Column(name="post_id", nullable = false)
    private int postId;
}
