package com.mgoportfolio2022api.mgoportfolio2022api.service.mapper;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumCategoryDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumImageDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumPostDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumCategoryEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlbumPostMapper implements EntityMapper<AlbumPostDTO, AlbumPostEntity> {

    @Autowired
    private AlbumPostDaoImpl albumPostDao;

    @Autowired
    private AlbumImageDaoImpl albumImageDao;

    @Autowired
    private AlbumCategoryDaoImpl albumCategoryDao;

    @Override
    public AlbumPostDTO toDto(AlbumPostEntity albumPostEntity){

            AlbumPostDTO dto = new AlbumPostDTO();
            int postId = albumPostEntity.getId();
            Optional<List<AlbumImageEntity>> albumImageEntitiesOptional = albumImageDao.findByPostId(postId);

            List<AlbumCategoryEntity> albumCategoryEntities = albumCategoryDao.findByPostId(1);

            dto.setId(albumPostEntity.getId());
            dto.setTitle(albumPostEntity.getTitle());
            dto.setDescription(albumPostEntity.getDescription());
            dto.setCountry(albumPostEntity.getCountry());
            dto.setLat(albumPostEntity.getLat());
            dto.setLng(albumPostEntity.getLng());


            //mapping of albumImageIds
            if(albumImageEntitiesOptional.isPresent()){
                List<AlbumImageEntity> albumImageEntities = albumImageEntitiesOptional.get();
                long[] imageIds = new long[albumImageEntities.size()];
                for(int i=0; i<albumImageEntities.size(); i++){
                    imageIds[i] = albumImageEntities.get(i).getImageId();
                }
                dto.setImageIds(imageIds);
            }


            //mapping of category
            Map<Integer, List<Long>> imageIdsOfEachCategory = new HashMap<>();

            for(AlbumCategoryEntity albumCategoryEntity:albumCategoryEntities){
               int categoryId = albumCategoryEntity.getCategoryId();
               long imageId = albumCategoryEntity.getAlbumImageEntity().getImageId();
               List<Long> imageIdsOfTheCategory = imageIdsOfEachCategory.get(categoryId);
               if(imageIdsOfTheCategory != null){
                   imageIdsOfTheCategory.add(imageId);
                   imageIdsOfEachCategory.put(categoryId,imageIdsOfTheCategory);
                   continue;
               }
                imageIdsOfTheCategory = new ArrayList<>();
                imageIdsOfTheCategory.add(imageId);
               imageIdsOfEachCategory.put(categoryId, imageIdsOfTheCategory);
            }

            dto.setCategoryIds(imageIdsOfEachCategory);

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
