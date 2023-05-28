package com.mgoportfolio2022api.mgoportfolio2022api.controller;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumCategoryRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumCategoryDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumCategoryEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.AlbumPostService;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins="*")
public class AlbumPostController {

    @Autowired
    private AlbumPostService albumPostService;

    @Autowired
    private AlbumCategoryRepository albumCategoryRepository;

    @Autowired
    private AlbumCategoryDaoImpl albumCategoryDao;


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

    //trial
    @GetMapping("/categories")
    public List<AlbumCategoryEntity> getAlbumImageCategories(){
        System.out.println(albumCategoryRepository.findAll());
        return albumCategoryRepository.findAll();}


    //trial
    @GetMapping("/category")
    public List<AlbumCategoryEntity> getCategoryByPostId(){return albumCategoryDao.findByPostId(1);}
}
