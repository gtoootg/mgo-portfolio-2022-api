package com.mgoportfolio2022api.mgoportfolio2022api.controller;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.AlbumPostService;
import com.mgoportfolio2022api.mgoportfolio2022api.service.AlbumImageService;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AlbumPostController {

    private AlbumPostService albumPostService;

    private AlbumImageService photoAlbumFlickrImageService;

    public AlbumPostController(
            AlbumPostService theAlbumPostService,
            AlbumImageService thePhotoAlbumFlickrImageService
    ){
        albumPostService =theAlbumPostService;
        photoAlbumFlickrImageService = thePhotoAlbumFlickrImageService;
    }


    @GetMapping("/albumposts")
    public List<AlbumPostDTO> getAlbumPosts(){
        return albumPostService.getAlbumPostsWithImageIds();
    }

    @GetMapping("/flickrImages")
    public List<AlbumImageEntity> getPhotoAlbumFlickrImage(){
        return photoAlbumFlickrImageService.findAll();
    }

}
