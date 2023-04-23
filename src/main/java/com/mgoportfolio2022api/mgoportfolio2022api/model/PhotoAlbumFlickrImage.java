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
    @Column(name="flickrPhotoId",nullable = false)
    private BigInteger flickrPhotoId;

    @Column(name="postId", nullable = false)
    private int postId;
//    @ManyToOne
//    @JoinColumn(name="postId",nullable = false)
//    private AlbumPost albumPost;
}
