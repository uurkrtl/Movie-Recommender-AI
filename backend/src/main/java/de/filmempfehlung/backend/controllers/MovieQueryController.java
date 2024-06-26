package de.filmempfehlung.backend.controllers;

import de.filmempfehlung.backend.services.abstracts.MovieQueryService;
import de.filmempfehlung.backend.services.dtos.responses.MovieGetAllResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie-queries")
@RequiredArgsConstructor
public class MovieQueryController {
    private final MovieQueryService movieQueryService;

    @GetMapping("/{queryId}")
    List<MovieGetAllResponse> getMoviesByQueryId(@PathVariable String queryId) {
        return movieQueryService.getMoviesByQueryId(queryId);
    }
}
