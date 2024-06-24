package de.filmempfehlung.backend.controllers;

import de.filmempfehlung.backend.services.abstracts.MovieService;
import de.filmempfehlung.backend.services.dtos.requests.OpenAiMovieRequest;
import de.filmempfehlung.backend.services.dtos.responses.MovieCreatedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/generate")
    List<MovieCreatedResponse> generateAndSaveMovieList(@RequestBody OpenAiMovieRequest openAiMovieRequest) {
        return movieService.generateAndSaveMovieList(openAiMovieRequest);
    }
}
