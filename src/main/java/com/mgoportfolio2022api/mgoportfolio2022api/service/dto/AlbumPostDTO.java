package com.mgoportfolio2022api.mgoportfolio2022api.service.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
    private Number lat;
    @JsonProperty(value="lng")
    private Number lng;
    @JsonProperty(value="flickrPhotoId")
    private Integer[] flickrPhotoId;
    @JsonProperty(value="categories")
    private Map<String, int[]> categories;

}
