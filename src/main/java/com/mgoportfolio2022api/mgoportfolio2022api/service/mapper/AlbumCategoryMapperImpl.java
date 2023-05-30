package com.mgoportfolio2022api.mgoportfolio2022api.service.mapper;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumCategoryEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AlbumCategoryMapperImpl implements AlbumCategoryMapperInterface{
    @Override
    public List<AlbumCategoryEntity> toEntity(Map<Long, List<Long>> imageIdsForEachCategory, List<AlbumImageEntity> savedAlbumImageEntities) {


        List<AlbumCategoryEntity> albumCategoryEntities = new ArrayList<>();

        List<Map<String, Long>> arrayForCategoryAndImageId = new ArrayList<>();

        for(Map.Entry<Long, List<Long>> entry : imageIdsForEachCategory.entrySet()){
            long category_id = entry.getKey();
            List<Long> image_ids = entry.getValue();

            for (long image_id : image_ids) {
                Map<String, Long> element = new HashMap<>();
                element.put("category_id", category_id);
                element.put("image_id", image_id);
                arrayForCategoryAndImageId.add(element);
            }
        }

        for(Map<String, Long> categoryAndImageId : arrayForCategoryAndImageId){
            AlbumCategoryEntity albumCategoryEntity = new AlbumCategoryEntity();

            long categoryId = categoryAndImageId.get("category_id");
            long imageId = categoryAndImageId.get("image_id");

            Optional<AlbumImageEntity> albumImageEntityOptional = savedAlbumImageEntities.stream().filter(entity -> entity.getImageId() == imageId).findFirst();

            if(!albumImageEntityOptional.isPresent()){
                continue;
            }

            AlbumImageEntity albumImageEntity = albumImageEntityOptional.get();

            albumCategoryEntity.setCategoryId(categoryId);
            albumCategoryEntity.setSavedAlbumImageEntity(albumImageEntity);

            albumCategoryEntities.add(albumCategoryEntity);
        }

        return  albumCategoryEntities;
    }
}
