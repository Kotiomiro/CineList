package com.cinelist.cinelist_api.controller;


import com.cinelist.cinelist_api.domain.Movie;
import com.cinelist.cinelist_api.infra.security.annotation.RequireAdminPermission;
import com.cinelist.cinelist_api.repository.MovieRepository;
import com.cinelist.cinelist_api.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("movie")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    MovieRepository movieRepository;

    @Value("${tmdb.api.key}")
    private String apiKey;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/search")
    public Movie searchMovie(@RequestParam String title) {
        return movieService.searchMovieByTitle(title);
    }


    @GetMapping("/list")
    public List<Movie> getAllMovies() {
        return movieService.showMovieList();
    }

    @RequireAdminPermission
    @DeleteMapping("/delete/id/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }










}
