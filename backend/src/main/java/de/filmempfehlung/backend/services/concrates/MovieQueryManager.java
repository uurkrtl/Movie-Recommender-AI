package de.filmempfehlung.backend.services.concrates;

import de.filmempfehlung.backend.core.mappers.ModelMapperService;
import de.filmempfehlung.backend.models.MovieQuery;
import de.filmempfehlung.backend.repositories.MovieQueryRepository;
import de.filmempfehlung.backend.services.abstracts.IdService;
import de.filmempfehlung.backend.services.abstracts.MovieQueryService;
import de.filmempfehlung.backend.services.dtos.requests.MovieQueryRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MovieQueryManager implements MovieQueryService {
    private final MovieQueryRepository movieQueryRepository;
    private final IdService idService;
    private final ModelMapperService modelMapperService;

    @Override
    public void addRequestQuery(MovieQueryRequest movieQueryRequest) {
        MovieQuery movieQuery = modelMapperService.forRequest().map(movieQueryRequest, MovieQuery.class);
        movieQuery.setId(idService.generateQueryId());
        movieQuery.setCreatedAt(LocalDateTime.now());
        movieQueryRepository.save(movieQuery);
    }
}
