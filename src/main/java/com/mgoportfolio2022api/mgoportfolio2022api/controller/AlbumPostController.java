package com.mgoportfolio2022api.mgoportfolio2022api.controller;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPost;
import com.mgoportfolio2022api.mgoportfolio2022api.service.AlbumPostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
public class AlbumPostController {

    private AlbumPostService albumPostService;

    public AlbumPostController(AlbumPostService theAlbumPostService){
        albumPostService =theAlbumPostService;
    }

    @GetMapping("/albumposts")
    public List<AlbumPost> getAlbumPosts(){
        System.out.println(albumPostService.findAll());
        return albumPostService.findAll();
    }

}
