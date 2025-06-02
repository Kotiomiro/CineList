package com.cinelist.cinelist_api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {
    private Long id;
    @JsonProperty("title")
    private String titulo;
    @JsonProperty("description")
    private String descricao;
    @JsonProperty("poster_url")
    private String posterUrl;
    @JsonProperty("realease_date")
    private String dataLancamento;
    @JsonProperty("avaliation")
    private Double nota;

}
