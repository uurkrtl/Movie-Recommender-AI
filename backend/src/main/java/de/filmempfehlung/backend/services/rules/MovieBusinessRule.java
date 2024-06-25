package de.filmempfehlung.backend.services.rules;

import de.filmempfehlung.backend.models.Movie;
import de.filmempfehlung.backend.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieBusinessRule {
    private final MovieRepository movieRepository;

    public String checkIfThemoviedbIdExists(String themoviedbId) {
        Optional<Movie> movie = movieRepository.findByThemoviedbId(themoviedbId);
        return movie.map(Movie::getId).orElse(null);

    }
}
