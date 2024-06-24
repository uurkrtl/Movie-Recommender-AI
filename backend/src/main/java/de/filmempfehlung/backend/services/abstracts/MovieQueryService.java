package de.filmempfehlung.backend.services.abstracts;

import de.filmempfehlung.backend.services.dtos.requests.MovieQueryRequest;

public interface MovieQueryService {
    void addRequestQuery(MovieQueryRequest movieQueryRequest);
}
