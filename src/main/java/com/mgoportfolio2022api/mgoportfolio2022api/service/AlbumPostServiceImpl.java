package com.mgoportfolio2022api.mgoportfolio2022api.service;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumImageDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.album.AlbumPostDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.AlbumPostDTO;
import com.mgoportfolio2022api.mgoportfolio2022api.service.mapper.AlbumPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumPostServiceImpl implements AlbumPostService {

    @Autowired
    private AlbumPostDaoImpl albumPostDao;

    @Autowired
    private AlbumImageDaoImpl albumImageDao;

    private AlbumPostMapper albumPostMapper;

    public List<AlbumPostDTO> getAlbumPostsWithImageIds() {
        return albumPostMapper.toDto();
    }
}
