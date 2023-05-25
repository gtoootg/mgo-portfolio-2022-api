package com.mgoportfolio2022api.mgoportfolio2022api.service;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumImageDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumPostDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.mapper.AlbumImageMapperImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.service.mapper.AlbumPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
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

    @Autowired
    private AlbumImageMapperImpl albumImageMapper;

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

    @Override
    public AlbumPostEntity createAlbumPost(AlbumPostDTO albumPostDto) {
        AlbumPostEntity savedAlbumPost = albumPostDao.save(albumPostMapper.toEntity(albumPostDto));

        BigInteger[] imageIds = albumPostDto.getImageIds();
        int postId=savedAlbumPost.getId();

        List<AlbumImageEntity> albumPostEntities = albumImageMapper.toEntity(imageIds,postId);

        albumImageDao.saveAll(albumPostEntities);

        return savedAlbumPost;
    }

}
