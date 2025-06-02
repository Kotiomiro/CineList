package com.cinelist.cinelist_api.repository;

import com.cinelist.cinelist_api.model.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MovieRepository extends JpaRepository<Movie, UUID> {
    List<Movie> findByMovieId(Long movieId);
}
