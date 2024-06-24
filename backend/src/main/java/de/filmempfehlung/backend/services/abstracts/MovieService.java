package de.filmempfehlung.backend.services.abstracts;

import de.filmempfehlung.backend.services.dtos.responses.MovieCreatedResponse;

import java.util.List;

public interface MovieService {
    List<MovieCreatedResponse> generateAndSaveMovieList(String genrePreference);
}
