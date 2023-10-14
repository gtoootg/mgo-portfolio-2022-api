package com.mgoportfolio2022api.mgoportfolio2022api.dao.common;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.CommonCategoryRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.common.CommonCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommonCategoryDaoImpl implements CommonCategoryDaoInterface{

    @Autowired
    private CommonCategoryRepository commonCategoryRepository;
    @Override
    public List<CommonCategoryEntity> findAll() {
        return commonCategoryRepository.findAll();
    }
}
