package com.mgoportfolio2022api.mgoportfolio2022api.dao.album;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;

import java.util.List;
import java.util.Optional;

public interface AlbumImageDaoInterface {

    public List<AlbumImageEntity> findAll();

    public Optional<AlbumImageEntity> findById(int id);

    public Optional<List<AlbumImageEntity>> findByPostId(int postId);

    public List<AlbumImageEntity> saveAll(List<AlbumImageEntity> albumImageEntities);
}
