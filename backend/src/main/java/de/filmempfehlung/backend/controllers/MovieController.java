package de.filmempfehlung.backend.controllers;

import de.filmempfehlung.backend.services.abstracts.MovieService;
import de.filmempfehlung.backend.services.dtos.requests.OpenAiMovieRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @PostMapping("/generate")
    @ResponseStatus(HttpStatus.CREATED)
    String generateAndSaveMovieList(@RequestBody OpenAiMovieRequest openAiMovieRequest) {
        return movieService.generateAndSaveMovieList(openAiMovieRequest);
    }
}
