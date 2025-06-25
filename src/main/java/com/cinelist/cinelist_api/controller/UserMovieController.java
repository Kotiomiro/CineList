package com.cinelist.cinelist_api.controller;


import com.cinelist.cinelist_api.domain.user.UserMovie;
import com.cinelist.cinelist_api.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user-movies")
public class UserMovieController {

    @Autowired
    private UserMovieRepository userMovieRepository;


    @GetMapping("/watched/{userId}")
    public List<UserMovie> getWatchedMovies(@PathVariable UUID userId) {
        return userMovieRepository.findByUserIdAndWatched(userId, true);
    }

    @GetMapping("/not-watched/{userId}")
    public List<UserMovie> getNotWatchedMovies(@PathVariable UUID userId) {
        return userMovieRepository.findByUserIdAndWatched(userId, false);
    }
}
