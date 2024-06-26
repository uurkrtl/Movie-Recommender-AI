package de.filmempfehlung.backend.controllers;

import de.filmempfehlung.backend.models.themoviedb.Genre;
import de.filmempfehlung.backend.services.abstracts.TheMovieDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/themoviedb")
@RequiredArgsConstructor
public class TheMovieDbController {
    private final TheMovieDbService theMovieDbService;

    @GetMapping("/get-genres")
    public List<Genre> getMovieGenres() {
        return theMovieDbService.getMovieGenres();
    }
}
