package com.mgoportfolio2022api.mgoportfolio2022api.service;


import com.mgoportfolio2022api.mgoportfolio2022api.dao.PhotoAlbumFlickrImageRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.PhotoAlbumFlickrImage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoAlbumFlickrImageServiceImpl implements PhotoAlbumFlickrImageService{

    private PhotoAlbumFlickrImageRepository photoAlbumFlickrImageRepository;

    public PhotoAlbumFlickrImageServiceImpl(PhotoAlbumFlickrImageRepository thePhotoAlbumFlickrImageService) {
        photoAlbumFlickrImageRepository = thePhotoAlbumFlickrImageService;
    }

    @Override
    public List<PhotoAlbumFlickrImage> findAll() {
        return photoAlbumFlickrImageRepository.findAll();
    }
}
