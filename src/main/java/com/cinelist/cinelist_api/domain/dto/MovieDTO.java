package com.cinelist.cinelist_api.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {
    private Long id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("overview")
    private String synopsis;

    @JsonProperty(value = "poster_path", access = JsonProperty.Access.WRITE_ONLY)
    private String posterPath;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("vote_average")
    private Double avaliation;

    @JsonProperty("posterUrl")
    public String getPosterUrl() {
        if (posterPath != null && !posterPath.isEmpty()) {
            return "https://image.tmdb.org/t/p/w500" + posterPath;
        }
        return null;
    }

    @JsonProperty("director")
    private String director;
}
