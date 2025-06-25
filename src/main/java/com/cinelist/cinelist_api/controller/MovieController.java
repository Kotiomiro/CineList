package com.cinelist.cinelist_api.controller;


import com.cinelist.cinelist_api.domain.Movie;
import com.cinelist.cinelist_api.services.MovieService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("movie")
public class MovieController {

    private final RestTemplate restTemplate;
    private final MovieService movieService;

    @Value("${tmdb.api.key}")
    private String apiKey;

    public MovieController(RestTemplate restTemplate, MovieService movieService) {
        this.restTemplate = restTemplate;
        this.movieService = movieService;
    }


    @GetMapping("/search")
    public Movie searchMovie(@RequestParam String title) {
        return movieService.searchMovieByTitle(title);
    }


    @GetMapping("/search/id/{id}")
    public Movie searchMovieById(@PathVariable Long id) {
        return movieService.searchMovieById(id);
    }

    @GetMapping("/list")
    public List<Movie> getAllMovies() {
        return movieService.showMovieList();
    }











}
