package com.mgoportfolio2022api.mgoportfolio2022api.dao.album;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumCategoryEntity;

import java.util.List;
import java.util.Optional;

public interface AlbumCategoryDaoInterface {

    public List<AlbumCategoryEntity> findAll();

    public Optional<AlbumCategoryEntity> findById(int id);

    public Optional<List<AlbumCategoryEntity>> findByPostId(int postId);

}
