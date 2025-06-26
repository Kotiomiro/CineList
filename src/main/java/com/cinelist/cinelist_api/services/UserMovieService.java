package com.cinelist.cinelist_api.services;

import com.cinelist.cinelist_api.domain.Movie;
import com.cinelist.cinelist_api.domain.User;
import com.cinelist.cinelist_api.domain.entities.UserMovie;
import com.cinelist.cinelist_api.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMovieService {

    @Autowired
    UserMovieRepository userMovieRepository;

    public void addMovieToWatched(UserMovie userMovie) {
        if (!Boolean.TRUE.equals(userMovie.getWatched())) {
            userMovie.setWatched(true);
        }
    }

    public void addMovieToFavorite(UserMovie userMovie) {
        if (!Boolean.TRUE.equals(userMovie.getIsFavorite()) && Boolean.TRUE.equals(userMovie.getWatched())) {
            userMovie.setIsFavorite(true);
        }
    }

}
