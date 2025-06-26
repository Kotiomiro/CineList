package com.cinelist.cinelist_api.controller;


import com.cinelist.cinelist_api.domain.Movie;
import com.cinelist.cinelist_api.domain.User;
import com.cinelist.cinelist_api.domain.entities.UserMovie;
import com.cinelist.cinelist_api.infra.security.annotation.RequireUserPermission;
import com.cinelist.cinelist_api.repository.UserMovieRepository;
import com.cinelist.cinelist_api.services.UserMovieService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user-movies")
public class UserMovieController {

    private final UserMovieService userMovieService;

    public UserMovieController(UserMovieService userMovieService) {
        this.userMovieService = userMovieService;
    }

    @Autowired
    private UserMovieRepository userMovieRepository;

    @RequireUserPermission
    @PostMapping("/add/new_watched_movie")
    public void addMovieToWatched(@RequestParam UserMovie userMovie) {
        userMovieService.addMovieToWatched(userMovie);
    }

    @RequireUserPermission
    @PutMapping("/add/new_favorite_movie")
    public void addMovieToFavorite(@RequestParam UserMovie userMovie) {
        userMovieService.addMovieToFavorite(userMovie);
    }

    @RequireUserPermission
    @GetMapping("/watched/{userId}")
    public List<UserMovie> getWatchedMovies(@PathVariable UUID userId) {
        return userMovieRepository.findByUserIdAndWatched(userId, true);
    }

    @RequireUserPermission
    @GetMapping("/not-watched/{userId}")
    public List<UserMovie> getNotWatchedMovies(@PathVariable UUID userId) {
        return userMovieRepository.findByUserIdAndWatched(userId, false);
    }

    @RequireUserPermission
    @DeleteMapping
    public void deleteUserMovie(@RequestParam UserMovie userMovie) {
        userMovieRepository.deleteById(userMovie.getId());
    }
}
