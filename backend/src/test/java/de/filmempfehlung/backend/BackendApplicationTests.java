package de.filmempfehlung.backend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(properties = {"spring.ai.openai.api-key=dummy-key"})
@TestPropertySource(properties = {"themoviedb.api-key=dummy-key"})
class BackendApplicationTests {

    @Test
    void contextLoads() {
    }

}
