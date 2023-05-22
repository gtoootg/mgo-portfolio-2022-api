package com.mgoportfolio2022api.mgoportfolio2022api.dao.album;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumPostRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AlbumPostDaoImpl implements AlbumPostDaoInterface{

    @Autowired
    private AlbumPostRepository albumPostRepository;

    @Override
    public List<AlbumPostEntity> findAll(){
        return albumPostRepository.findAll();
    }

    @Override
    public Optional<AlbumPostEntity> findById(int id){
        return albumPostRepository.findById(id);
    }

}
