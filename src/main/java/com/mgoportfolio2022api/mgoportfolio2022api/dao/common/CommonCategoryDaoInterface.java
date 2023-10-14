package com.mgoportfolio2022api.mgoportfolio2022api.dao.common;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.CommonCategoryRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.common.CommonCategoryEntity;

import java.util.List;

public interface CommonCategoryDaoInterface {

    public List<CommonCategoryEntity> findAll();
}
