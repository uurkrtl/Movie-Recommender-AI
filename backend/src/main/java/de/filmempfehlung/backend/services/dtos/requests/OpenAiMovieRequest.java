package de.filmempfehlung.backend.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OpenAiMovieRequest {
    private String genre;
    private String actorDirector;
    private String moodTheme;
    private double minRating;
    private String specialInterest;
}
