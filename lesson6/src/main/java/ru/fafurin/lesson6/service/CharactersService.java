package ru.fafurin.lesson6.service;

import lombok.AllArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.fafurin.lesson6.model.Character;
import ru.fafurin.lesson6.repository.CharacterRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CharactersService {

    private final Environment environment;

    private final CharacterRepository repository;

    public Page<Character> findPaginatedCharacters(int page) {
        return repository.findAll(PageRequest.of(page, Integer.parseInt(environment.getProperty("CHARACTERS_BY_PAGE"))));
    }

    public Optional<Character> findCharacterById(int id) {
        return repository.findById(id);
    }
}
