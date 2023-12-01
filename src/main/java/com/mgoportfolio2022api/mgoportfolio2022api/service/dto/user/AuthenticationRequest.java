package com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user;


import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AuthenticationRequest {
  private  String username;
  private  String password;

}
