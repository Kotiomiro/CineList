package com.cinelist.cinelist_api.domain.entities;

import com.cinelist.cinelist_api.domain.Movie;
import com.cinelist.cinelist_api.domain.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Table
@Entity
public class UserMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    private Boolean watched;

    private Boolean isFavorite;

}
