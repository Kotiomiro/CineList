package com.cinelist.cinelist_api.services;

import com.cinelist.cinelist_api.repository.UserMovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMovieService {

    @Autowired
    UserMovieRepository userMovieRepository;


}
