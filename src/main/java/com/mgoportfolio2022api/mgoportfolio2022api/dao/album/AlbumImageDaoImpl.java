package com.mgoportfolio2022api.mgoportfolio2022api.dao.album;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumImageRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class AlbumImageDaoImpl implements AlbumImageDaoInterface {

    @Autowired
    private AlbumImageRepository albumImageRepository;


    @Override
    public List<AlbumImageEntity> findAll() {
        return albumImageRepository.findAll();
    }

    @Override
    public Optional<AlbumImageEntity> findById(int id) {
        return albumImageRepository.findById(id);
    }

    @Override
    public
    Optional<List<AlbumImageEntity>> findByPostId(int postId) {
        return albumImageRepository.findByPostId(postId);
    }
}
