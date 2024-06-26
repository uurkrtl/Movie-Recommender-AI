package de.filmempfehlung.backend.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {
    private String movieName;
    private String movieNameGerman;
    private double imdbRating;
    private String headliner;
    private int releaseYear;
    private String posterPath;
    private String overview;
    private String themoviedbId;
}
