package com.mgoportfolio2022api.mgoportfolio2022api.dao.album;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumCategoryRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
public class AlbumCategoryDaoImpl implements  AlbumCategoryDaoInterface{

    @Autowired
    private AlbumCategoryRepository albumCategoryRepository;

    @Override
    public List<AlbumCategoryEntity> findAll() {


        return albumCategoryRepository.findAll();
    }

    @Override
    public Optional<AlbumCategoryEntity> findById(int id) {
        return albumCategoryRepository.findById(id);
    }

    @Override
    public List<AlbumCategoryEntity> findByPostId(int postId) {
        System.out.println( albumCategoryRepository.findAll());
        List<AlbumCategoryEntity> albumCategoryEntities = albumCategoryRepository.findAll();
        List<AlbumCategoryEntity> filteredCategories = albumCategoryEntities.stream()
                .filter(category -> category.getSavedAlbumImageEntity().getPostId() == postId)
                .collect(Collectors.toList());

        return filteredCategories;

    }

    @Override
    public List<AlbumCategoryEntity> saveAll(List<AlbumCategoryEntity> albumCategoryEntities) {
        return albumCategoryRepository.saveAll(albumCategoryEntities);
    }
}
