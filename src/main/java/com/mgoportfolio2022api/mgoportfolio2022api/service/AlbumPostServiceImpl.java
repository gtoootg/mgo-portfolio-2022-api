package com.mgoportfolio2022api.mgoportfolio2022api.service;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumCategoryDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumImageDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumPostDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumCategoryEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.UpdateAlbumPostDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.mapper.AlbumCategoryMapperImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.service.mapper.AlbumImageMapperImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.service.mapper.AlbumPostMapper;
import com.mgoportfolio2022api.mgoportfolio2022api.service.mapper.UpdateAlbumPostMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumPostServiceImpl implements AlbumPostService {

    @Autowired
    private AlbumPostDaoImpl albumPostDao;

    @Autowired
    private AlbumImageDaoImpl albumImageDao;

    @Autowired
    private AlbumCategoryDaoImpl albumCategoryDao;

    @Autowired
    private AlbumPostMapper albumPostMapper;

    @Autowired
    private AlbumImageMapperImpl albumImageMapper;

    @Autowired
    private UpdateAlbumPostMapper updateAlbumPostMapper;

    @Autowired
    AlbumCategoryMapperImpl albumCategoryMapper;

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

        long[] imageIds = albumPostDto.getImageIds();
        int postId=savedAlbumPost.getId();

        List<AlbumImageEntity> albumPostEntities = albumImageMapper.toEntity(imageIds,postId);

        List<AlbumImageEntity> savedAlbumImageEntities =albumImageDao.saveAll(albumPostEntities);

        List<AlbumCategoryEntity> albumCategoryEntities = albumCategoryMapper.toEntity(albumPostDto.getCategoryIds(),savedAlbumImageEntities);

        albumCategoryDao.saveAll(albumCategoryEntities);

        return savedAlbumPost;
    }

    @Override
    public AlbumPostEntity updateAlbumPost(UpdateAlbumPostDTO updateAlbumPostDTO){

        AlbumPostEntity albumPostEntityToUpdate = updateAlbumPostMapper.toEntity(updateAlbumPostDTO);

        AlbumPostEntity updatedAlbumPost = albumPostDao.save(albumPostEntityToUpdate);

        return updatedAlbumPost;
    }
}
