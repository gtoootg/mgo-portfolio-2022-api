package com.mgoportfolio2022api.mgoportfolio2022api.dao.user;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.UserRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserDaoImpl implements UserDaoInterface{
    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<UserEntity> findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }
}
