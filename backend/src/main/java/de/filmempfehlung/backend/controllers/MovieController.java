package de.filmempfehlung.backend.controllers;

import de.filmempfehlung.backend.services.abstracts.MovieService;
import de.filmempfehlung.backend.services.dtos.requests.OpenAiMovieRequest;
import de.filmempfehlung.backend.services.dtos.responses.MovieCreatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * This is a REST controller for managing movies.
 * It uses Spring's @RestController annotation, so it's assumed that all methods return @ResponseBody by default.
 * The @RequestMapping("/api/movies") annotation is used to map web requests onto specific handler methods.
 * It is a required arguments constructor, meaning that it requires an argument of type MovieService to be instantiated.
 */
@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    // The MovieService is automatically injected by Spring due to the @RequiredArgsConstructor annotation from Lombok.
    private final MovieService movieService;

    /**
     * This method is used to generate and save a movie list.
     * It is mapped to the POST HTTP method and the "/generate" URL path.
     * The @ResponseStatus annotation is used to define the HTTP status code that should be returned.
     * The OpenAiMovieRequest object is automatically populated from the JSON in the request body due to the @RequestBody annotation.
     * @param openAiMovieRequest the request body containing the parameters for generating the movie list
     * @return a String indicating the result of the operation
     */
    @PostMapping("/generate")
    @ResponseStatus(HttpStatus.CREATED)
    public String generateAndSaveMovieList(@RequestBody OpenAiMovieRequest openAiMovieRequest) {
        return movieService.generateAndSaveMovieList(openAiMovieRequest);
    }

    /**
     * This method is used to get a movie by its ID.
     * It is mapped to the GET HTTP method and the "/{id}" URL path, where {id} is a path variable.
     * The @PathVariable annotation is used to bind the method parameter to the path variable.
     * @param id the ID of the movie to retrieve
     * @return a MovieCreatedResponse object containing the details of the requested movie
     */
    @GetMapping("/{id}")
    public MovieCreatedResponse getMovieByMovieId(@PathVariable String id) {
        return movieService.getMovieByMovieId(id);
    }
}
