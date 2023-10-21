package com.mgoportfolio2022api.mgoportfolio2022api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Optional;

@Data
public class UpdateAlbumPostDTO {
    @JsonProperty(value="id")
    private int id;
    @JsonProperty(value="title")
    private Optional<String> title;
    @JsonProperty(value="description")
    private Optional<String> description;

}
