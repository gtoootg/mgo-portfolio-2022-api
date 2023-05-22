package com.mgoportfolio2022api.mgoportfolio2022api.service;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumImageDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumPostDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.mapper.AlbumPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumPostServiceImpl implements AlbumPostService {

    @Autowired
    private AlbumPostDaoImpl albumPostDao;

    @Autowired
    private AlbumImageDaoImpl albumImageDao;

    @Autowired
    private AlbumPostMapper albumPostMapper;

    @Override
    public List<AlbumPostDTO> getAlbumPostsWithImageIds() {
        List<AlbumPostEntity> albumPostEntities = albumPostDao.findAll();
        List<AlbumPostDTO> albumPostDtos = new ArrayList<>();

        for(AlbumPostEntity albumPostEntity:albumPostEntities){
            AlbumPostDTO albumPostDto = albumPostMapper.toDto(albumPostEntity);

            albumPostDtos.add(albumPostDto);
        }
        return albumPostDtos;
    }
}
