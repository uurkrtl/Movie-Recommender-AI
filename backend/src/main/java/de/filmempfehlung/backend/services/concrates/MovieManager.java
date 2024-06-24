package de.filmempfehlung.backend.services.concrates;

import de.filmempfehlung.backend.core.mappers.ModelMapperService;
import de.filmempfehlung.backend.models.Movie;
import de.filmempfehlung.backend.models.OpenAiMovie;
import de.filmempfehlung.backend.models.themoviedb.MovieDetail;
import de.filmempfehlung.backend.repositories.MovieRepository;
import de.filmempfehlung.backend.services.abstracts.*;
import de.filmempfehlung.backend.services.dtos.requests.MovieQueryRequest;
import de.filmempfehlung.backend.services.dtos.requests.OpenAiMovieRequest;
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
    private final MovieQueryService movieQueryService;

    @Override
    public List<MovieCreatedResponse> generateAndSaveMovieList(OpenAiMovieRequest openAiMovieRequest) {
        List<OpenAiMovie> generatedMovies = openAiService.getMovies(openAiMovieRequest);
        List<Movie> movies = new ArrayList<>();
        for (OpenAiMovie openAiMovie : generatedMovies){
            Movie movie = modelMapperService.forRequest().map(openAiMovie, Movie.class);
            MovieDetail movieDetail = theMovieDbService.getMovieDetail(movie.getThemoviedbId());
            movie.setOverview(movieDetail.getOverview());
            movie.setPosterPath(movieDetail.getPosterPath());
            movie.setId(idService.generateMovieId());
            movie.setCreatedAt(LocalDateTime.now());
            movie = movieRepository.save(movie);
            movies.add(movie);
        }
        movieQueryService.addRequestQuery(MovieQueryRequest.builder().openAiMovieRequest(openAiMovieRequest).movies(movies).build());
        return movies.stream().map(movie -> modelMapperService.forResponse().map(movie, MovieCreatedResponse.class)).toList();
    }
}
