package com.cinelist.cinelist_api.domain;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Movie {

    @Id
    @Column(name = "tmdb_id", nullable = false)
    private Long tmdbId;
    @Column(unique = true)
    private String title;
    @Column(columnDefinition = "TEXT")
    private String synopsis;
    @Column(columnDefinition = "TEXT")
    private String genre;
    private int year;
    private String director;
    private Double rating;
    @Column(columnDefinition = "TEXT")
    private String poster_path;
    @Column(columnDefinition = "TEXT")
    private String poster_url;
    private Date release_date;
}
