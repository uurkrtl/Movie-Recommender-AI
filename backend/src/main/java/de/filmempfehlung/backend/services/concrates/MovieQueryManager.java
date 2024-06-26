package de.filmempfehlung.backend.services.concrates;

import de.filmempfehlung.backend.core.mappers.ModelMapperService;
import de.filmempfehlung.backend.models.Movie;
import de.filmempfehlung.backend.models.MovieQuery;
import de.filmempfehlung.backend.repositories.MovieQueryRepository;
import de.filmempfehlung.backend.services.abstracts.IdService;
import de.filmempfehlung.backend.services.abstracts.MovieQueryService;
import de.filmempfehlung.backend.services.dtos.requests.MovieQueryRequest;
import de.filmempfehlung.backend.services.dtos.responses.MovieGetAllResponse;
import de.filmempfehlung.backend.services.messages.MovieQueryMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieQueryManager implements MovieQueryService {
    private final MovieQueryRepository movieQueryRepository;
    private final IdService idService;
    private final ModelMapperService modelMapperService;

    @Override
    public List<MovieGetAllResponse> getMoviesByQueryId(String queryId) {
        Optional<MovieQuery> optionalMovieQuery = movieQueryRepository.findById(queryId);
        if (optionalMovieQuery.isPresent()) {
            List<Movie> movieList = optionalMovieQuery.get().getMovies();
            return movieList.stream().map(movie -> modelMapperService.forResponse().map(movie, MovieGetAllResponse.class)).toList();
        } else {
            throw new NotFoundException(MovieQueryMessage.QUERY_NOT_FOUND);
        }
    }

    @Override
    public String addRequestQuery(MovieQueryRequest movieQueryRequest) {
        MovieQuery movieQuery = modelMapperService.forRequest().map(movieQueryRequest, MovieQuery.class);
        movieQuery.setId(idService.generateQueryId());
        movieQuery.setCreatedAt(LocalDateTime.now());
        return movieQueryRepository.save(movieQuery).getId();
    }
}
