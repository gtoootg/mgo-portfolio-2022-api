package com.mgoportfolio2022api.mgoportfolio2022api.dao;

import com.mgoportfolio2022api.mgoportfolio2022api.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity,String> {

    public Optional<UserEntity> findByUserName(String userName);

}
