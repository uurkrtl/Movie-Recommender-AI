package de.filmempfehlung.backend.services.abstracts;

import de.filmempfehlung.backend.services.dtos.requests.MovieQueryRequest;
import de.filmempfehlung.backend.services.dtos.responses.MovieGetAllResponse;

import java.util.List;

public interface MovieQueryService {
    List<MovieGetAllResponse> getMoviesByQueryId(String queryId);
    String addRequestQuery(MovieQueryRequest movieQueryRequest);
}
