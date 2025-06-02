package com.cinelist.cinelist_api.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import javax.xml.stream.events.Comment;
import java.util.List;

@Entity
@Table
public class Movie {
    @Id
    private Long id;
    private String title;
    private String synopsis;
    private Integer year;
    private String genre;
    private String director;
    private String cast;
    private Double averageRating;

    @OneToMany(mappedBy = "movie")
    private List<Comment> comments;
}




