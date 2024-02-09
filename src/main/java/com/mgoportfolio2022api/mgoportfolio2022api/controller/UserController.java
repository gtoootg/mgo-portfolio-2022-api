package com.mgoportfolio2022api.mgoportfolio2022api.controller;

import com.mgoportfolio2022api.mgoportfolio2022api.dao.UserRepository;
import com.mgoportfolio2022api.mgoportfolio2022api.error.exeption.NotFoundException;
import com.mgoportfolio2022api.mgoportfolio2022api.model.user.UserEntity;
import com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user.GetUserDTO;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("")
  public String getUser(){
    return "hi";
  }

  @GetMapping("/users")
  public List<UserEntity> getUsers(){
    return userRepository.findAll();
  }

  @PostMapping("/user")
  public Optional<UserEntity> getUserById(@RequestBody GetUserDTO getUserDTO){

    Integer userId = getUserDTO.getUserId();

    Optional<UserEntity> user = userRepository.findById(userId);

    if(!user.isPresent()){
      throw new NotFoundException("user is not found");
    }

    return user;
  }

}
