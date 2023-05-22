package com.mgoportfolio2022api.mgoportfolio2022api.controller;

import com.mgoportfolio2022api.mgoportfolio2022api.service.AlbumPostService;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class AlbumPostController {

    @Autowired
    private AlbumPostService albumPostService;


    public AlbumPostController(
            AlbumPostService theAlbumPostService
    ){
        albumPostService =theAlbumPostService;
    }


    @GetMapping("/albumposts")
    public List<AlbumPostDTO> getAlbumPosts(){
        return albumPostService.getAlbumPostsWithImageIds();
    }

}
