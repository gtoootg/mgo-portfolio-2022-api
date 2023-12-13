package com.mgoportfolio2022api.mgoportfolio2022api.controller;

import com.mgoportfolio2022api.mgoportfolio2022api.error.BadRequestException;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.AlbumPostService;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.UpdateAlbumPostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AlbumPostController {

    @Autowired
    private AlbumPostService albumPostService;


    @GetMapping("/albumposts")
    public List<AlbumPostDTO> getAlbumPosts(){
        return albumPostService.getAlbumPostsWithImageIds();
    }

    @PostMapping("/albumpost")
    public AlbumPostEntity createAlbumPost(@RequestBody AlbumPostDTO albumPostDTO){
        String title = albumPostDTO.getTitle();
        String description = albumPostDTO.getDescription();
        if( title.length()>=100){
            throw new BadRequestException("title is too long");
        }

        if(description.length()>=1000){
            throw new BadRequestException("description too long");
        }

        return albumPostService.createAlbumPost(albumPostDTO);}

    @PutMapping("/albumpost")
    public AlbumPostEntity updateAlbumPost(@RequestBody UpdateAlbumPostDTO updateAlbumPostDTO ){

        Optional<String> title = updateAlbumPostDTO.getTitle();
        Optional<String> description = updateAlbumPostDTO.getDescription();


        if(title.isPresent() && title.get().length()>=100){
            throw new BadRequestException("title is too long");
        }

        if(description.isPresent() && description.get().length()>=1000){
            throw new BadRequestException("description too long");
        }

        return albumPostService.updateAlbumPost(updateAlbumPostDTO)

    ;}


}
