package com.cinelist.cinelist_api.dto.user;

import java.util.UUID;

public record UserMovieDTO(UUID userId, Long movieId, Boolean watched, Boolean isFavorite) {
}
