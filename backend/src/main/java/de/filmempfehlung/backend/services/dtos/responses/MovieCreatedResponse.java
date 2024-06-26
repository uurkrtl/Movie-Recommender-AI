package de.filmempfehlung.backend.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieCreatedResponse {
    private String id;
    private String movieName;
    private String movieNameGerman;
    private double imdbRating;
    private String headliner;
    private int releaseYear;
    private String posterPath;
    private String overview;
}
