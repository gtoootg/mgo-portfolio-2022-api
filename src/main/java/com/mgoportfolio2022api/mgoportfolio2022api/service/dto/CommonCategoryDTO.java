package com.mgoportfolio2022api.mgoportfolio2022api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CommonCategoryDTO {


    @JsonProperty(value="id")
    private Integer id;
    @JsonProperty(value="label")
    private String label;
}
