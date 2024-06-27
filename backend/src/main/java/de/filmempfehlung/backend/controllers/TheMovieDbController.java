package de.filmempfehlung.backend.controllers;

import de.filmempfehlung.backend.models.themoviedb.Genre;
import de.filmempfehlung.backend.services.abstracts.TheMovieDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This is a REST controller for managing TheMovieDb related operations.
 * It uses Spring's @RestController annotation, so it's assumed that all methods return @ResponseBody by default.
 * The @RequestMapping("/api/themoviedb") annotation is used to map web requests onto specific handler methods.
 * It is a required arguments constructor, meaning that it requires an argument of type TheMovieDbService to be instantiated.
 */
@RestController
@RequestMapping("/api/themoviedb")
@RequiredArgsConstructor
public class TheMovieDbController {
    // The TheMovieDbService is automatically injected by Spring due to the @RequiredArgsConstructor annotation from Lombok.
    private final TheMovieDbService theMovieDbService;

    /**
     * This method is used to get a list of movie genres from TheMovieDb.
     * It is mapped to the GET HTTP method and the "/get-genres" URL path.
     * @return a List of Genre objects containing the details of the movie genres
     */
    @GetMapping("/get-genres")
    public List<Genre> getMovieGenres() {
        return theMovieDbService.getMovieGenres();
    }
}
