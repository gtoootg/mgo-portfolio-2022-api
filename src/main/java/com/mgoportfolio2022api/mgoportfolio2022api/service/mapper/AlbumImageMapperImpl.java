package com.mgoportfolio2022api.mgoportfolio2022api.service.mapper;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumImageMapperImpl implements  AlbumImageMapperInterface{

    @Override
    public List<AlbumImageEntity> toEntity(long[] imageIds, int postId){
        List<AlbumImageEntity> albumImageEntities = new ArrayList<>();

        for(long imageId:imageIds){
            AlbumImageEntity newAlbumImageEntity = new AlbumImageEntity();
            newAlbumImageEntity.setImageId(imageId);
            newAlbumImageEntity.setPostId(postId);
            albumImageEntities.add(newAlbumImageEntity);
        }

       return albumImageEntities;
    }


}
