package com.mgoportfolio2022api.mgoportfolio2022api.dao.company;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumPostRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.mapper.AlbumPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumPostDaoImpl implements AlbumPostDaoInterface{
    @Autowired
    private AlbumPostRepository albumPostRepository;

    @Autowired
    private AlbumPostMapper albumPostMapper;

    public List<AlbumPostDTO> getAlbumPostsWithImageIds(){
        List<AlbumPostEntity> albumPostEntities = albumPostRepository.findAll();
        List<AlbumPostDTO> albumPostDTOs = new ArrayList<>();

        for(AlbumPostEntity albumPostEntity:albumPostEntities){
                AlbumPostDTO albumPostDTO = albumPostMapper.toDto(albumPostEntity);
                albumPostDTOs.add(albumPostDTO);
            }
        return albumPostDTOs;
    }


}
