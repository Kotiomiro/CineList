package com.cinelist.cinelist_api.repository;

import com.cinelist.cinelist_api.domain.Movie;
import com.cinelist.cinelist_api.domain.User;
import com.cinelist.cinelist_api.domain.entities.UserMovie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserMovieRepository extends JpaRepository<UserMovie, UUID> {

    List<UserMovie> findByUserIdAndWatched(UUID userId, Boolean watched);
    UserMovie findByUser(User user);



}
