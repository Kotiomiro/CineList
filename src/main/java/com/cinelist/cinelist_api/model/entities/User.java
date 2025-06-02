package com.cinelist.cinelist_api.model.entities;

import jakarta.persistence.*;

import javax.xml.stream.events.Comment;
import java.util.List;
import java.util.UUID;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;

    @OneToMany(mappedBy = "user")
    private List<Comment> comentarios;

    @OneToMany
    private List<Movie> favoritos;

    @OneToMany(mappedBy = "user")
    private List<Movie> assistidos;

}
