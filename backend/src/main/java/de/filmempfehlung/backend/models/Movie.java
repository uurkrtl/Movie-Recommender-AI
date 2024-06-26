package de.filmempfehlung.backend.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "movies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    @Id
    private String id;
    private String movieName;
    private String movieNameGerman;
    private double imdbRating;
    private String headliner;
    private int releaseYear;
    private String posterPath;
    private String overview;
    private String themoviedbId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
