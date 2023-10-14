package com.mgoportfolio2022api.mgoportfolio2022api.dao;


import com.mgoportfolio2022api.mgoportfolio2022api.model.common.CommonCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonCategoryRepository extends JpaRepository<CommonCategoryEntity,Integer> {
}
