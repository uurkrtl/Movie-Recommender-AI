package de.filmempfehlung.backend.services.abstracts;

import de.filmempfehlung.backend.models.OpenAiMovie;

import java.util.List;

public interface OpenAiService {
    List<OpenAiMovie> getMovies(String genrePreference);
}
