package com.mgoportfolio2022api.mgoportfolio2022api.service.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;

@Data
public class AlbumPostDTO {

    private int id;

    @JsonProperty(value="title")
    private String title;
    @JsonProperty(value="description")
    private String description;
    @JsonProperty(value="country")
    private String country;
    @JsonProperty(value="lat")
    private BigDecimal lat;
    @JsonProperty(value="lng")
    private BigDecimal lng;

    @JsonProperty(value="imageIds")
    private BigInteger[] imageIds;

    @JsonProperty(value="categoryIds")
    private Map<Integer, BigInteger[]> categoryIds;


}
