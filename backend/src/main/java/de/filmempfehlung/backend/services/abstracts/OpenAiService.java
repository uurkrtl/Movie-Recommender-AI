package de.filmempfehlung.backend.services.abstracts;

import de.filmempfehlung.backend.models.OpenAiMovie;
import de.filmempfehlung.backend.services.dtos.requests.OpenAiMovieRequest;

import java.util.List;

public interface OpenAiService {
    List<OpenAiMovie> getMovies(OpenAiMovieRequest openAiMovieRequest);
}
