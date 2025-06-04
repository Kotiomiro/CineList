package com.cinelist.cinelist_api.config.services;

import com.cinelist.cinelist_api.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MovieRepository movieRepository;


    public void importarFilmesPopulares() {



    }


}
