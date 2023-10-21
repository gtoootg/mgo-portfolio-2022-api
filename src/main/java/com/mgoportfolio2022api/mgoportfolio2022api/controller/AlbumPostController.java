package com.mgoportfolio2022api.mgoportfolio2022api.controller;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.AlbumPostService;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.UpdateAlbumPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/albumpost")
    public AlbumPostEntity createAlbumPost(@RequestBody AlbumPostDTO albumPostDTO){return albumPostService.createAlbumPost(albumPostDTO);}

    @PutMapping("/albumpost")
    public AlbumPostEntity updateAlbumPost(@RequestBody UpdateAlbumPostDTO updateAlbumPostDTO ){return albumPostService.updateAlbumPost(updateAlbumPostDTO);}

}
