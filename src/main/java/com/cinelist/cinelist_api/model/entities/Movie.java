package com.cinelist.cinelist_api.model.entities;

import jakarta.persistence.*;

import com.cinelist.cinelist_api.model.entities.Comment;
import java.util.List;
import java.util.UUID;

@Entity
@Table
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




