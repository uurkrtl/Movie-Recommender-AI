package de.filmempfehlung.backend.services.abstracts;

import de.filmempfehlung.backend.models.themoviedb.Genre;
import de.filmempfehlung.backend.models.themoviedb.MovieDetail;

import java.util.List;

public interface TheMovieDbService {
    MovieDetail getMovieDetail(String id);
    List<Genre> getMovieGenres();
}
