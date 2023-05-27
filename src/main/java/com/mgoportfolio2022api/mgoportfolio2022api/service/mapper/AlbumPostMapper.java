package com.mgoportfolio2022api.mgoportfolio2022api.service.mapper;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumImageDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumPostDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class AlbumPostMapper implements EntityMapper<AlbumPostDTO, AlbumPostEntity> {

    @Autowired
    private AlbumPostDaoImpl albumPostDao;

    @Autowired
    private AlbumImageDaoImpl albumImageDao;

    @Override
    public AlbumPostDTO toDto(AlbumPostEntity albumPostEntity){

            AlbumPostDTO dto = new AlbumPostDTO();
            Optional<List<AlbumImageEntity>> albumImageEntitiesOptional = albumImageDao.findByPostId(albumPostEntity.getId());

            dto.setId(albumPostEntity.getId());
            dto.setTitle(albumPostEntity.getTitle());
            dto.setDescription(albumPostEntity.getDescription());
            dto.setCountry(albumPostEntity.getCountry());
            dto.setLat(albumPostEntity.getLat());
            dto.setLng(albumPostEntity.getLng());

            if(albumImageEntitiesOptional.isPresent()){
                List<AlbumImageEntity> albumImageEntities = albumImageEntitiesOptional.get();
                BigInteger[] imageIds = new BigInteger[albumImageEntities.size()];
                for(int i=0; i<albumImageEntities.size(); i++){
                    imageIds[i] = albumImageEntities.get(i).getImageId();
                }
                dto.setImageIds(imageIds);
            }

        return dto;
    }

    @Override
    public AlbumPostEntity toEntity(AlbumPostDTO albumPostDTO) {
        AlbumPostEntity albumPostEntity = new AlbumPostEntity();

        albumPostEntity.setTitle(albumPostDTO.getTitle());
        albumPostEntity.setDescription(albumPostDTO.getDescription());
        albumPostEntity.setCountry(albumPostDTO.getCountry());
        albumPostEntity.setLat(albumPostDTO.getLat());
        albumPostEntity.setLng(albumPostDTO.getLng());

        return albumPostEntity;
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
