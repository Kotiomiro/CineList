package com.cinelist.cinelist_api.services;

import com.cinelist.cinelist_api.domain.Movie;
import com.cinelist.cinelist_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {

    @Value("${tmdb.api.key}")
    private String key;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MovieRepository movieRepository;

    public ResponseEntity<?> searchMovie(@RequestParam String query) {
        return null;
    }


    public List<Movie> showMovieList() {
        return movieRepository.findAll();
    }

    public Movie searchMovieById(Long id) {
        return movieRepository.findMovieByTmdbId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()).getBody();
    }

    public Movie searchMovieByTitle(String title) {
        return movieRepository.findMovieByTitle(title)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build()).getBody();
    }

}
