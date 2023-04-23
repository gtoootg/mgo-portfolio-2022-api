package com.mgoportfolio2022api.mgoportfolio2022api.service;

import com.mgoportfolio2022api.mgoportfolio2022api.model.PhotoAlbumFlickrImage;

import java.util.List;

public interface PhotoAlbumFlickrImageService {

    List<PhotoAlbumFlickrImage> findAll();

//    List<PhotoAlbumFlickrImage> flickrImages = PhotoAlbumFlickrImageRepository.findByPostId(postId);

}
