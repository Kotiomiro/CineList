package com.cinelist.cinelist_api.model;

import com.cinelist.cinelist_api.repository.MovieRepository;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String title;
    private String synopsis;
    private Integer year;
    private String genre;
    private String director;
    private String cast;
    private Double averageRating;

    @OneToMany
    private List<Comment> comments;
}




