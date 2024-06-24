package de.filmempfehlung.backend.repositories;

import de.filmempfehlung.backend.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieRepository extends MongoRepository<Movie, String> {
}
