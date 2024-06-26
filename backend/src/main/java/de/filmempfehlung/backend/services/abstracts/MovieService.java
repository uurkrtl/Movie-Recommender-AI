package de.filmempfehlung.backend.services.abstracts;

import de.filmempfehlung.backend.services.dtos.requests.OpenAiMovieRequest;
import de.filmempfehlung.backend.services.dtos.responses.MovieCreatedResponse;

public interface MovieService {
    String generateAndSaveMovieList(OpenAiMovieRequest openAiMovieRequest);
    MovieCreatedResponse getMovieByMovieId(String id);
}
