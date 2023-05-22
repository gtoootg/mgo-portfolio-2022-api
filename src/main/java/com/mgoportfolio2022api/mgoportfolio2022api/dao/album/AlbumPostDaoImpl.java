package com.mgoportfolio2022api.mgoportfolio2022api.dao.album;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumPostRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;

import java.util.List;
import java.util.Optional;

public class AlbumPostDaoImpl implements AlbumPostDaoInterface{

    private AlbumPostRepository albumPostRepository;

    @Override
    public List<AlbumPostEntity> findAll(){
        return albumPostRepository.findAll();
    }

    public Optional<AlbumPostEntity> findById(int id){
        return albumPostRepository.findById(id);
    }

}
