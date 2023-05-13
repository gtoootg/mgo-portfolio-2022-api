package com.mgoportfolio2022api.mgoportfolio2022api.service;


import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumImageRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumImageServiceImpl implements AlbumImageService {

    private AlbumImageRepository albumImageRepository;

    @Autowired
    public AlbumImageServiceImpl(AlbumImageRepository theAlbumImageService) {
        albumImageRepository = theAlbumImageService;
    }

    @Override
    public List<AlbumImageEntity> findAll() {
        return albumImageRepository.findAll();
    }
}
