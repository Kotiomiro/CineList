package com.cinelist.cinelist_api.infra;

import com.cinelist.cinelist_api.domain.User;
import com.cinelist.cinelist_api.domain.enums.UserRole;
import org.springframework.security.core.context.SecurityContextHolder;

public class UserContextProvider {

    private UserContextProvider() {
    }

    public static User getUser() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new RuntimeException("User is not authenticated");
        }

        return (User) authentication.getPrincipal();
    }

    public static boolean isUserUnauthorized(String authorizedUsername) {
        var userDetails = getUser();
        var isUsernameMatching = userDetails.getUsername().equals(authorizedUsername);
        var isAdmin = userDetails
                .getAuthorities()
                .stream()
                .anyMatch(authority -> authority.getAuthority().equals("ROLE_" + UserRole.ADMIN.name()));

        return !isUsernameMatching && !isAdmin;
    }

}
