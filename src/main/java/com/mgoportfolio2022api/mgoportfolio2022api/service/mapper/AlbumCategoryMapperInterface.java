package com.mgoportfolio2022api.mgoportfolio2022api.service.mapper;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumCategoryEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;

import java.util.List;
import java.util.Map;

public interface AlbumCategoryMapperInterface {

        public List<AlbumCategoryEntity> toEntity(Map<Long, List<Long>> categoryIdsForImages, List<AlbumImageEntity> savedAlbumImageEntities);

}
