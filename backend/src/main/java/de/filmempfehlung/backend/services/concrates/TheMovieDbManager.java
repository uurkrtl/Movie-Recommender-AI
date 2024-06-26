package de.filmempfehlung.backend.services.concrates;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.filmempfehlung.backend.models.themoviedb.Genre;
import de.filmempfehlung.backend.models.themoviedb.GenreResponse;
import de.filmempfehlung.backend.models.themoviedb.MovieDetail;
import de.filmempfehlung.backend.services.abstracts.TheMovieDbService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Service
public class TheMovieDbManager implements TheMovieDbService {
    private static final String API_MOVIE_DETAIL_URL = "https://api.themoviedb.org/3/movie/%s?language=de-DE";
    public static final String API_GENRE_URL = "https://api.themoviedb.org/3/genre/movie/list?language=de";

    @Value("${themoviedb.api-key}")
    private String apiKey;

    @Override
    public MovieDetail getMovieDetail(String id) {
        MovieDetail movieDetail;
        HttpClient client = HttpClient.newHttpClient();

        String apiUrlWithId = String.format(API_MOVIE_DETAIL_URL, id);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiUrlWithId))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                ObjectMapper mapper = new ObjectMapper();
                movieDetail = mapper.readValue(responseBody, MovieDetail.class);
            } else {
                throw new NotFoundException("Movie not found. Please try again. Request failed with status code: " + response.statusCode());
            }
        } catch (IOException e) {
            throw new NotFoundException("Movie not found. Please try again. Request failed with exception: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new NotFoundException("Movie not found. Please try again. Request failed with exception: " + e.getMessage());
        }

        return movieDetail;
    }

    @Override
    public List<Genre> getMovieGenres() {
        GenreResponse genreResponse;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_GENRE_URL))
                .header("accept", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .GET()
                .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                String responseBody = response.body();
                ObjectMapper mapper = new ObjectMapper();
                genreResponse = mapper.readValue(responseBody, GenreResponse.class);
            } else {
                throw new NotFoundException("Genres not found. Please try again. Request failed with status code: " + response.statusCode());
            }
        } catch (IOException e) {
            throw new NotFoundException("Genres not found. Please try again. Request failed with exception: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new NotFoundException("Genres not found. Please try again. Request failed with exception: " + e.getMessage());
        }

        return genreResponse.getGenres();
    }
}
