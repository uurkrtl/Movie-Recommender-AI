package de.filmempfehlung.backend.services.concrates;

import de.filmempfehlung.backend.models.OpenAiMovie;
import de.filmempfehlung.backend.services.abstracts.OpenAiService;
import de.filmempfehlung.backend.services.dtos.requests.OpenAiMovieRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class OpenAiManager implements OpenAiService {
    private final ChatClient chatClient;

    public OpenAiManager(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @Override
    public List<OpenAiMovie> getMovies(OpenAiMovieRequest openAiMovieRequest) {
        StringBuilder requestQuery = new StringBuilder();
        requestQuery.append("Can you recommend max. 3 movies?");
        if (!openAiMovieRequest.getGenre().isEmpty()) requestQuery.append(" Genre: ").append(openAiMovieRequest.getGenre());
        if (!openAiMovieRequest.getActorDirector().isEmpty()) requestQuery.append(" Favorite Actor or Director: ").append(openAiMovieRequest.getActorDirector());
        if (!openAiMovieRequest.getMoodTheme().isEmpty()) requestQuery.append(" Mood or theme: ").append(openAiMovieRequest.getMoodTheme());
        if (openAiMovieRequest.getMinRating()> 0) requestQuery.append(" Minimum IMDB rating: ").append(openAiMovieRequest.getMinRating());
        if (!Objects.equals(openAiMovieRequest.getSpecialInterest(), "")) requestQuery.append(" Special interest: ").append(openAiMovieRequest.getSpecialInterest());

        return chatClient.prompt()
                .user(u -> u.text("Can you recommend max. 3 movies? {requestQuery}").param("requestQuery", String.valueOf(requestQuery)))
                .call()
                .entity(new ParameterizedTypeReference<>() {});
    }
}
