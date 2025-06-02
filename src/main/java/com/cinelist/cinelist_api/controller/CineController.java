package com.cinelist.cinelist_api.controller;

import com.cinelist.cinelist_api.dto.MovieDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    public ResponseEntity<?> searchMovie(@RequestParam String query) {
        try {
            String url = "https://api.themoviedb.org/3/search/movie?query=" + query + "&api_key=" + apiKey;
            String json = restTemplate.getForObject(url, String.class);

            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(json);

            // Verifica se existe "results" e se não está vazio
            JsonNode results = root.path("results");
            if (results.isMissingNode() || !results.isArray() || results.size() == 0) {
                return ResponseEntity.status(404).body("Nenhum filme encontrado para a busca: " + query);
            }

            JsonNode firstMovie = results.get(0);

            MovieDTO dto = mapper.treeToValue(firstMovie, MovieDTO.class);

            return ResponseEntity.ok(dto);

        } catch (Exception e) {
            e.printStackTrace();  // Para debugar o erro no console
            return ResponseEntity.status(500).body("Erro ao buscar filme: " + e.getMessage());
        }
    }



}
