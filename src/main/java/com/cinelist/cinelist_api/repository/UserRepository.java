package com.cinelist.cinelist_api.repository;

import com.cinelist.cinelist_api.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    UserDetails findByLogin(String login);
    Optional<User> findByUsername(String username);
    void deleteById(UUID id);
    Optional<User> deleteByUsername(String username);
}
