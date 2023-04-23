package com.mgoportfolio2022api.mgoportfolio2022api.service;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumPostRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumPostServiceImpl implements AlbumPostService {

    private AlbumPostRepository albumPostRepository;

    @Autowired
    public AlbumPostServiceImpl(AlbumPostRepository theAlbumPostRepository){
        albumPostRepository = theAlbumPostRepository;
    }

    @Override
    public List<AlbumPost> findAll() {
        return albumPostRepository.findAll();
    }
}
