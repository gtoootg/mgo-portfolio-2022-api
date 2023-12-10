package com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user;

import com.mgoportfolio2022api.mgoportfolio2022api.model.user.UserEntity;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor
public class UserUtils {

  @Autowired
  private final List<UserEntity> existingUsers;

  public boolean isUserExists(RegisterUserDTO registerUserDTO){
    UserEntity[] usersArray = existingUsers.toArray(new UserEntity[existingUsers.size()]);
    String newUserName = registerUserDTO.getUsername();
    String newUserEmail = registerUserDTO.getEmail();
    return Arrays.stream(usersArray).anyMatch(user->user.getEmail()==newUserEmail || user.getUsername()==newUserName);
  }
}
