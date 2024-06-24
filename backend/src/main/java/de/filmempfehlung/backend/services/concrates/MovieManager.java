package de.filmempfehlung.backend.services.concrates;

import de.filmempfehlung.backend.core.mappers.ModelMapperService;
import de.filmempfehlung.backend.models.Movie;
import de.filmempfehlung.backend.models.OpenAiMovie;
import de.filmempfehlung.backend.models.themoviedb.MovieDetail;
import de.filmempfehlung.backend.repositories.MovieRepository;
import de.filmempfehlung.backend.services.abstracts.IdService;
import de.filmempfehlung.backend.services.abstracts.MovieService;
import de.filmempfehlung.backend.services.abstracts.OpenAiService;
import de.filmempfehlung.backend.services.abstracts.TheMovieDbService;
import de.filmempfehlung.backend.services.dtos.responses.MovieCreatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieManager implements MovieService {
    private final MovieRepository movieRepository;
    private final IdService idService;
    private final ModelMapperService modelMapperService;
    private final OpenAiService openAiService;
    private final TheMovieDbService theMovieDbService;

    @Override
    public List<MovieCreatedResponse> generateAndSaveMovieList(String genrePreference) {
        List<OpenAiMovie> generatedMovies = openAiService.getMovies(genrePreference);
        List<Movie> movies = new ArrayList<>();
        for (OpenAiMovie openAiMovie : generatedMovies){
            Movie movie = modelMapperService.forRequest().map(openAiMovie, Movie.class);
            MovieDetail movieDetail = theMovieDbService.getMovieDetail(movie.getThemoviedbId());
            movie.setOverview(movieDetail.getOverview());
            movie.setPosterPath(movieDetail.getPoster_path());
            movie.setId(idService.generateMovieId());
            movie.setCreatedAt(LocalDateTime.now());
            movie = movieRepository.save(movie);
            movies.add(movie);
        }
        return movies.stream().map(movie -> modelMapperService.forResponse().map(movie, MovieCreatedResponse.class)).toList();
    }
}
