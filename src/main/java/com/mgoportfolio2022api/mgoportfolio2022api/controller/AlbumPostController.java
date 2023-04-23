package com.mgoportfolio2022api.mgoportfolio2022api.controller;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPost;
import com.mgoportfolio2022api.mgoportfolio2022api.service.AlbumPostService;
import com.mgoportfolio2022api.mgoportfolio2022api.service.PhotoAlbumFlickrImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AlbumPostController {

    private AlbumPostService albumPostService;

    //dummy, can be removed
    private PhotoAlbumFlickrImageService photoAlbumFlickrImageService;

    public AlbumPostController(AlbumPostService theAlbumPostService, PhotoAlbumFlickrImageService thePhotoAlbumFlickrImageService){
        albumPostService =theAlbumPostService;
        photoAlbumFlickrImageService = thePhotoAlbumFlickrImageService;
    }


    @GetMapping("/albumposts")
    public List<AlbumPost> getAlbumPosts(){
        System.out.println(photoAlbumFlickrImageService.findAll());
        return albumPostService.findAll();
    }

}
