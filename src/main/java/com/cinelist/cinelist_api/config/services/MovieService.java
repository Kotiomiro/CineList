package com.cinelist.cinelist_api.config.services;

import com.cinelist.cinelist_api.model.Movie;
import com.cinelist.cinelist_api.repository.MovieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

@Service
public class MovieService {

    @Value("${tmdb.api.key}")
    private String key;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MovieRepository movieRepository;

    public void importarFilmesPopulares() throws JsonProcessingException {

        String url = "https://api.themoviedb.org/3/movie/popular?api_key="+key+"&language=pt-BR&page=1";
        String response = restTemplate.getForObject(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response);

        JsonNode results = root.get("results");

        for(JsonNode movieNode : results) {

            Long movieId = movieNode.get("id").asLong();

            String detailsUrl = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + key + "&language=pt-BR";
            String detailsResponse = restTemplate.getForObject(detailsUrl, String.class);
            JsonNode detailsNode = mapper.readTree(detailsResponse);

            String creditsUrl = "https://api.themoviedb.org/3/movie/" + movieId + "/credits?api_key=" + key + "&language=pt-BR";
            String creditsResponse = restTemplate.getForObject(creditsUrl, String.class);
            JsonNode creditsNode = mapper.readTree(creditsResponse);


            String director = "";
            JsonNode crew = creditsNode.get("crew");
            for (JsonNode crewMember : crew) {
                if(crewMember.get("job").asText().equals("Director")) {
                    director = crewMember.get("name").asText();
                    break;
                }
            }

            StringBuilder genres = new StringBuilder();
            for(JsonNode genreNode : detailsNode.get("genres")) {
                if (genres.length() > 0) genres.append(", ");
                genres.append(genreNode.get("name").asText());
            }

            Movie movie = new Movie();
            movie.setId(movieId);
            movie.setTitle(detailsNode.get("title").asText());
            movie.setSynopsis(detailsNode.get("overview").asText());
            movie.setGenre(genres.toString());
            movie.setDirector(director);

            movieRepository.save(movie);
        }

    }


}
