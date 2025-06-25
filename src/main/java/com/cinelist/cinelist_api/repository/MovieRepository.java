package com.cinelist.cinelist_api.repository;

import com.cinelist.cinelist_api.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findMovieByTitle(String title);
    Optional<Movie> findMovieByTmdbId(Long tmdbId);

    List<Movie> findMoviesByGenre(String genre);
}
