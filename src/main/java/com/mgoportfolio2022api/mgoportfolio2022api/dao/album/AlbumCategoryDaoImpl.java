package com.mgoportfolio2022api.mgoportfolio2022api.dao.album;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumCategoryRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
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
    public Optional<List<AlbumCategoryEntity>> findByPostId(int postId) {

        List<AlbumCategoryEntity> albumCategoryEntities = albumCategoryRepository.findAll();
        AlbumCategoryEntity[] albumCategoryArray = albumCategoryEntities.toArray(new AlbumCategoryEntity[0]);
        List<AlbumCategoryEntity> filteredCategories  = Arrays.stream(albumCategoryArray).filter(category -> category.getAlbumImageEntity().getPostId() == postId).collect(Collectors.toList());

        return Optional.ofNullable(filteredCategories);
    }
}
