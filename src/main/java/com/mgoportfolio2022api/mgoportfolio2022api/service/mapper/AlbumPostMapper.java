package com.mgoportfolio2022api.mgoportfolio2022api.service.mapper;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.AlbumImageRepository;
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
public class AlbumPostMapper implements EntityMapper<AlbumPostDTO, AlbumPostEntity> {

    @Autowired
    private AlbumImageRepository albumImageRepository;

    @Override
    public AlbumPostEntity toEntity(AlbumPostDTO dto){
        AlbumPostEntity albumPostEntity = new AlbumPostEntity();
        albumPostEntity.setId(dto.getId());
        albumPostEntity.setTitle(dto.getTitle());
        albumPostEntity.setDescription(dto.getDescription());
        albumPostEntity.setCountry(dto.getCountry());
        albumPostEntity.setLat(dto.getLat());
        albumPostEntity.setLng(dto.getLng());

        return albumPostEntity;
    }

    @Override
    public AlbumPostDTO toDto(AlbumPostEntity entity){
        AlbumPostDTO albumPostDTO = new AlbumPostDTO();
        int postId = entity.getId();
        Optional<List<AlbumImageEntity>> albumImageEntitiesOptional = albumImageRepository.findByPostId(postId);

        if(entity ==null){
            return null;
        }

        albumPostDTO.setId(entity.getId());
        albumPostDTO.setTitle(entity.getTitle());
        albumPostDTO.setDescription(entity.getDescription());
        albumPostDTO.setCountry(entity.getCountry());
        albumPostDTO.setLat(entity.getLat());
        albumPostDTO.setLng(entity.getLng());

        if(albumImageEntitiesOptional.isPresent()){
            List<AlbumImageEntity> albumImageEntities = albumImageEntitiesOptional.get();
            BigInteger[] imageIds = new BigInteger[albumImageEntities.size()];

            for(int i = 0; i<albumImageEntities.size(); i++){
                imageIds[i] = albumImageEntities.get(i).getImageId();
            }
            albumPostDTO.setImageIds(imageIds);
        }

        return albumPostDTO;
    }

    @Override
    public List<AlbumPostEntity> toEntity(List<AlbumPostDTO> dtoList) {
        return null;
    }

    @Override
    public List<AlbumPostDTO> toDto(List<AlbumPostEntity> entityList) {
        return null;
    }


}
