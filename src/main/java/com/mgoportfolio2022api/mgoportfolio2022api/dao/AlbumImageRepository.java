package com.mgoportfolio2022api.mgoportfolio2022api.dao;

import com.mgoportfolio2022api.mgoportfolio2022api.model.AlbumImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumImageRepository extends JpaRepository<AlbumImageEntity,Integer> {

    Optional<List<AlbumImageEntity>> findByPostId(int postId);
}
