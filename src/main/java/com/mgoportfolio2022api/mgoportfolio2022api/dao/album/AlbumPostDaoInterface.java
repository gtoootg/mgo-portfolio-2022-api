package com.mgoportfolio2022api.mgoportfolio2022api.dao.album;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;

import java.util.List;
import java.util.Optional;

public interface AlbumPostDaoInterface {

    public List<AlbumPostEntity> findAll();

    public Optional<AlbumPostEntity> findById(int id);
}
