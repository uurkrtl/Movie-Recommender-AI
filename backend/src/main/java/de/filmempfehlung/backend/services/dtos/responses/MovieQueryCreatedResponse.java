package de.filmempfehlung.backend.services.dtos.responses;

import de.filmempfehlung.backend.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieQueryCreatedResponse {
    private String id;
    private String query;
    private List<Movie> movies;
}
