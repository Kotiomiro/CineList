package com.cinelist.cinelist_api.dto.user;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class UserMovieDTO {
    private UUID userId;
    private Long movieId;
    private Boolean watched;
    private Boolean isFavorite;
}
