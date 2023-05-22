package com.mgoportfolio2022api.mgoportfolio2022api.service.mapper;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumImageDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumPostDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AlbumPostMapper implements EntityMapper<AlbumPostDTO, AlbumPostEntity> {

    private AlbumPostDaoImpl albumPostDao;

    private AlbumImageDaoImpl albumImageDao;

    List<AlbumPostDTO> toDto(){
        List<AlbumPostEntity> albumPostEntities = albumPostDao.findAll();

        List<AlbumPostDTO> dtos = new ArrayList<>();

        for(AlbumPostEntity albumPostEntity:albumPostEntities){
            AlbumPostDTO dto = new AlbumPostDTO();

            dto.setId(albumPostEntity.getId());
            dto.setTitle(albumPostEntity.getTitle());
            dto.setDescription(albumPostEntity.getDescription());
            dto.setCountry(albumPostEntity.getCountry());
            dto.setLat(albumPostEntity.getLat());
            dto.setLng(albumPostEntity.getLng());

            Optional<List<AlbumImageEntity>> albumImageEntitiesOptional = albumImageDao.findByPostId(albumPostEntity.getId());

            if(albumImageEntitiesOptional.isPresent()){
                List<AlbumImageEntity> albumImageEntities = albumImageEntitiesOptional.get();
                BigInteger[] imageIds = new BigInteger[albumImageEntities.size()];
                for(int i=0; i<albumImageEntities.size(); i++){
                    imageIds[i] = albumImageEntities.get(i).getImageId();
                }
                dto.setImageIds(imageIds);
            }
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public AlbumPostEntity toEntity(AlbumPostDTO dto) {
        return null;
    }

    @Override
    public AlbumPostDTO toDto(AlbumPostEntity entity) {
        return null;
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
