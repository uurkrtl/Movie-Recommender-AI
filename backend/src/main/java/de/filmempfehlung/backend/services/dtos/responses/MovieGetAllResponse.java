package de.filmempfehlung.backend.services.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieGetAllResponse {
    private String id;
    private String movieName;
    private double imdbRating;
    private String headliner;
    private int releaseYear;
    private String posterPath;
    private String overview;
}
