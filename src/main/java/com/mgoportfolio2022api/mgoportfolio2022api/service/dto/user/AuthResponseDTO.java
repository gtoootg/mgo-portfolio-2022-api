package com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user;

import lombok.Data;

@Data
public class AuthResponseDTO {

  private  String  accessToken;
  private String tokenType = "Bearer";
  public AuthResponseDTO(String accessToken){
    this.accessToken =accessToken;
  }
}
