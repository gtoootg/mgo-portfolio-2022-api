package com.mgoportfolio2022api.mgoportfolio2022api.dao.user;

import com.mgoportfolio2022api.mgoportfolio2022api.model.UserEntity;

import java.util.Optional;

public interface UserDaoInterface {

    public Optional<UserEntity> findByUserName(String userName);
}
