package com.cinelist.cinelist_api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("cinelist")
public class CineController {


    private final RestTemplate restTemplate;

    public CineController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Value("${tmdb.api.key}")
    private String apiKey;


    @GetMapping("/search")
    public ResponseEntity<String> searchMovie(@RequestParam String query) {
        try {
            String url = "https://api.themoviedb.org/3/search/movie?query=" + query + "&api_key=" + apiKey;
            String response = restTemplate.getForObject(url, String.class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erro ao chamar TMDb: " + e.getMessage());
        }
    }



}
