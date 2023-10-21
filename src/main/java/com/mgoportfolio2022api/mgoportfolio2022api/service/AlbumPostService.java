package com.mgoportfolio2022api.mgoportfolio2022api.service;
import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumPostEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.UpdateAlbumPostDTO;

import java.util.List;


public interface AlbumPostService {

    List<AlbumPostDTO> getAlbumPostsWithImageIds(

    );

    AlbumPostEntity createAlbumPost(AlbumPostDTO albumPostDto);

    AlbumPostEntity updateAlbumPost(UpdateAlbumPostDTO updateAlbumPostDTO);
}
