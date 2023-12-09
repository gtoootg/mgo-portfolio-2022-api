package com.mgoportfolio2022api.mgoportfolio2022api.controller;
import com.mgoportfolio2022api.mgoportfolio2022api.dao.common.CommonCategoryDaoImpl;
import com.mgoportfolio2022api.mgoportfolio2022api.model.common.CommonCategoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/common")
public class CommonController {

    @Autowired
    CommonCategoryDaoImpl commonCategoryDao;

    @GetMapping("/categories")
    public List<CommonCategoryEntity> getCommonCategories(){return commonCategoryDao.findAll();}

}
