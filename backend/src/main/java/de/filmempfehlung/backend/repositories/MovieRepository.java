package de.filmempfehlung.backend.repositories;

import de.filmempfehlung.backend.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MovieRepository extends MongoRepository<Movie, String> {
    Optional<Movie> findByThemoviedbId(String themoviedbId);
}
