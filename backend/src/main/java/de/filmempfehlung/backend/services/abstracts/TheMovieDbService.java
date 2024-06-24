package de.filmempfehlung.backend.services.abstracts;

import de.filmempfehlung.backend.models.themoviedb.MovieDetail;

public interface TheMovieDbService {
    MovieDetail getMovieDetail(String id);
}
