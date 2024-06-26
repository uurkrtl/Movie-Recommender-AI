package de.filmempfehlung.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenAiMovie {
    private String movieName;
    private String movieNameGerman;
    private double imdbRating;
    private String headliner;
    private int releaseYear;
    private String themoviedbId;
}
