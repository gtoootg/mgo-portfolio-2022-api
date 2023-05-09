package com.mgoportfolio2022api.mgoportfolio2022api.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigInteger;

@Entity
@Table(name="photoalbum-flickr-image")
@Data
public class PhotoAlbumFlickrImage {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id",nullable = false)
    private int id;
    @Column(name="flickr_photo_id",nullable = false)
    private BigInteger flickrPhotoId;

    @Column(name="post_id", nullable = false)
    private int postId;
}
