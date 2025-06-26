package com.cinelist.cinelist_api.dto.auth;

import com.cinelist.cinelist_api.domain.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
