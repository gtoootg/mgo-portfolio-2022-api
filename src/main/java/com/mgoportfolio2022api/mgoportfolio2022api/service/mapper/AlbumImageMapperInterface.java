package com.mgoportfolio2022api.mgoportfolio2022api.service.mapper;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;

import java.math.BigInteger;
import java.util.List;

public interface AlbumImageMapperInterface {
    public List<AlbumImageEntity> toEntity(long[] imageIds, int postId);
}
