package com.mgoportfolio2022api.mgoportfolio2022api.service.mapper;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumPostDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.UpdateAlbumPostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateAlbumPostMapper {
    @Autowired
    private AlbumPostDaoImpl albumPostDao;

    public AlbumPostEntity toEntity(UpdateAlbumPostDTO updateAlbumPostDTO){
        int albumPostIdToUpdate = updateAlbumPostDTO.getId();
        Optional<AlbumPostEntity> albumPostEntityToUpdateOptional= albumPostDao.findById(albumPostIdToUpdate);

        AlbumPostEntity albumPostEntity = new AlbumPostEntity();

        if(!albumPostEntityToUpdateOptional.isPresent()){
            return albumPostEntity;
        }

        albumPostEntity = albumPostEntityToUpdateOptional.get();
        if(updateAlbumPostDTO.getTitle()!=null){
            albumPostEntity.setTitle(updateAlbumPostDTO.getTitle().get());
        }
        if(updateAlbumPostDTO.getDescription() !=null) {
           albumPostEntity.setDescription(updateAlbumPostDTO.getDescription().get());
        }

        return albumPostEntity;
    };
}
