package de.filmempfehlung.backend.repositories;

import de.filmempfehlung.backend.models.MovieQuery;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieQueryRepository extends MongoRepository<MovieQuery, String> {
}
