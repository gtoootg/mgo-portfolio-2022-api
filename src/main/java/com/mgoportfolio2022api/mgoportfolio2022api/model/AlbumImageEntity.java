package com.mgoportfolio2022api.mgoportfolio2022api.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigInteger;
import java.util.List;

@Entity
@Table(name="album_image")
@Data
public class AlbumImageEntity {

    @Id
    @Column(name="id",nullable = false)
    private int id;
    @Column(name="image_id",nullable = false)
    private long imageId;

    @Column(name="post_id", nullable = false)
    private int postId;

    @OneToMany(mappedBy = "savedAlbumImageEntity")
    @JsonIgnore
    @ToString.Exclude
    private List<AlbumCategoryEntity> albumCategoryEntities;
}
