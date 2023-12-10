package com.mgoportfolio2022api.mgoportfolio2022api.dao;


import com.mgoportfolio2022api.mgoportfolio2022api.model.user.UserEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {

     Optional<UserEntity> findByUsername(String username);

     Optional<UserEntity> findById(Integer userId);

     Boolean existsByUsername(String username);

     Boolean existsByEmail(String email);

}
