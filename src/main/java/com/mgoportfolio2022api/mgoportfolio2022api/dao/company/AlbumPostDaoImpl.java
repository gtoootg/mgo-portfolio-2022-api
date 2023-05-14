package com.mgoportfolio2022api.mgoportfolio2022api.dao.company;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumImageRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumPostRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumPostDaoImpl implements AlbumPostDaoInterface{
    @Autowired
    private AlbumPostRepository albumPostRepository;

    @Autowired
    private AlbumImageRepository albumImageRepository;

    public List<AlbumPostDTO> getAlbumPostsWithImageIds(){
        List<AlbumPostEntity> albumPostEntities = albumPostRepository.findAll();
        List<AlbumPostDTO> albumPostDTOs = new ArrayList<>();

        for(AlbumPostEntity albumPostEntity:albumPostEntities){
                AlbumPostDTO albumPostDTO = new AlbumPostDTO();
                int postId = albumPostEntity.getId();
                Optional<List<AlbumImageEntity>> albumImageEntitiesOptional = albumImageRepository.findByPostId(postId);

                albumPostDTO.setId(albumPostEntity.getId());
                albumPostDTO.setTitle(albumPostEntity.getTitle());
                albumPostDTO.setDescription(albumPostEntity.getDescription());
                albumPostDTO.setCountry(albumPostEntity.getCountry());
                albumPostDTO.setLng(albumPostEntity.getLng());
                albumPostDTO.setLat(albumPostEntity.getLat());

                if(albumImageEntitiesOptional.isPresent()){
                    List<AlbumImageEntity> albumImageEntities = albumImageEntitiesOptional.get();
                    BigInteger[] imageIds = new BigInteger[albumImageEntities.size()];

                    for(int i = 0; i < albumImageEntities.size(); i++){
                        imageIds[i] = albumImageEntities.get(i).getImageId();
                    }
                    albumPostDTO.setImageIds(imageIds);
                }
                albumPostDTOs.add(albumPostDTO);
            }
        return albumPostDTOs;
    }


}
