package com.cinelist.cinelist_api.model;

import com.cinelist.cinelist_api.repository.MovieRepository;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String synopsis;
    private Integer year;
    private String genre;
    private String director;
    private String cast;
    private Double averageRating;

}




