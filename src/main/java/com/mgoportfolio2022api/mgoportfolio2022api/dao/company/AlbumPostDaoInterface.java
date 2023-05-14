package com.mgoportfolio2022api.mgoportfolio2022api.dao.company;

import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;

import java.util.List;

public interface AlbumPostDaoInterface {
    List<AlbumPostDTO> getAlbumPostsWithImageIds();
}
