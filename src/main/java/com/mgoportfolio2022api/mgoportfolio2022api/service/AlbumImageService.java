package com.mgoportfolio2022api.mgoportfolio2022api.service;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;

import java.util.List;

public interface AlbumImageService {

    List<AlbumImageEntity> findAll();

//    List<PhotoAlbumFlickrImage> flickrImages = PhotoAlbumFlickrImageRepository.findByPostId(postId);

}
