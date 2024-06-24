package de.filmempfehlung.backend.services.concrates;

import de.filmempfehlung.backend.services.abstracts.IdService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdManager implements IdService {
    @Override
    public String generateMovieId() {
        return "MOV-" + UUID.randomUUID();
    }
}
