package com.cinelist.cinelist_api.domain.dto;

import com.cinelist.cinelist_api.domain.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
