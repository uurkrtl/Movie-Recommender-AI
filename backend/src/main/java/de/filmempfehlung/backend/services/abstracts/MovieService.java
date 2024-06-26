package de.filmempfehlung.backend.services.abstracts;

import de.filmempfehlung.backend.services.dtos.requests.OpenAiMovieRequest;

public interface MovieService {
    String generateAndSaveMovieList(OpenAiMovieRequest openAiMovieRequest);
}
