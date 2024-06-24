package de.filmempfehlung.backend.services.concrates;

import de.filmempfehlung.backend.models.OpenAiMovie;
import de.filmempfehlung.backend.services.abstracts.OpenAiService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpenAiManager implements OpenAiService {
    private final ChatClient chatClient;

    public OpenAiManager(ChatClient.Builder chatClient) {
        this.chatClient = chatClient.build();
    }

    @Override
    public List<OpenAiMovie> getMovies(String genrePreference) {
        return chatClient.prompt()
                .user(u -> u.text("Can you recommend 3 movies? Genre preference: {genrePreference}").param("genrePreference", genrePreference))
                .call()
                .entity(new ParameterizedTypeReference<>() {});
    }
}
