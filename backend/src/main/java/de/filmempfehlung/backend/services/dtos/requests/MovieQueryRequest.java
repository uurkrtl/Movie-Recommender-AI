package de.filmempfehlung.backend.services.dtos.requests;

import de.filmempfehlung.backend.models.Movie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MovieQueryRequest {
    private OpenAiMovieRequest openAiMovieRequest;
    private List<Movie> movies;
}
