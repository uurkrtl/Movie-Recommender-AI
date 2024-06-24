package de.filmempfehlung.backend.models;

import de.filmempfehlung.backend.services.dtos.requests.OpenAiMovieRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "request_queries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieQuery {
    @Id
    private String id;
    private OpenAiMovieRequest openAiMovieRequest;
    @DBRef
    private List<Movie> movies;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
