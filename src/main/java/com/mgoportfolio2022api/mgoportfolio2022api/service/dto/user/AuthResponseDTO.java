package com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Data
@RequiredArgsConstructor
@Setter
public class AuthResponseDTO {
  private  String  accessToken;
  private String tokenType = "Bearer";
  private Integer userId;

}
