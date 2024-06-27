package de.filmempfehlung.backend.controllers;

import de.filmempfehlung.backend.services.abstracts.MovieQueryService;
import de.filmempfehlung.backend.services.dtos.responses.MovieGetAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * This is a REST controller for managing movie queries.
 * It uses Spring's @RestController annotation, so it's assumed that all methods return @ResponseBody by default.
 * The @RequestMapping("/api/movie-queries") annotation is used to map web requests onto specific handler methods.
 * It is a required arguments constructor, meaning that it requires an argument of type MovieQueryService to be instantiated.
 */
@RestController
@RequestMapping("/api/movie-queries")
@RequiredArgsConstructor
public class MovieQueryController {
    // The MovieQueryService is automatically injected by Spring due to the @RequiredArgsConstructor annotation from Lombok.
    private final MovieQueryService movieQueryService;

    /**
     * This method is used to get movies by their query ID.
     * It is mapped to the GET HTTP method and the "/{queryId}" URL path, where {queryId} is a path variable.
     * The @PathVariable annotation is used to bind the method parameter to the path variable.
     * @param queryId the ID of the query to retrieve movies for
     * @return a List of MovieGetAllResponse objects containing the details of the requested movies
     */
    @GetMapping("/{queryId}")
    List<MovieGetAllResponse> getMoviesByQueryId(@PathVariable String queryId) {
        return movieQueryService.getMoviesByQueryId(queryId);
    }
}
