//package com.mgoportfolio2022api.mgoportfolio2022api.service.mapper;
//
//import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
//import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
//
//public class AlbumPostMapper implements EntityMapper<AlbumPostDTO, AlbumPostEntity> {
//
//    @Override
//    public AlbumPostEntity toEntity(AlbumPostDTO dto){
//        AlbumPostEntity albumPostEntity = new AlbumPostEntity();
//        albumPostEntity.setId(dto.getId());
//        albumPostEntity.setTitle(dto.getTitle());
//        albumPostEntity.setDescription(dto.getDescription());
//        albumPostEntity.setCountry(dto.getCountry());
//        albumPostEntity.setLat(dto.getLat());
//        albumPostEntity.setLng(dto.getLng());
//
//        return albumPostEntity;
//    }
//
//    @Override
//    public AlbumPostDTO toDto(AlbumPostEntity entity){
//        if(entity ==null){
//            return null;
//        }
//        Album
//    }
//
//}
