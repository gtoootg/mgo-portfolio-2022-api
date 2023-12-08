package com.mgoportfolio2022api.mgoportfolio2022api.service.dto.user;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GetUserDTO {
  @JsonProperty(value="userId")
  private Integer userId;

  public Integer getUserId() {
    return userId;
  }
}
