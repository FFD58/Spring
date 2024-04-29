package ru.fafurin.lesson6.controller.db;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.fafurin.lesson6.service.db.CharacterDBService;
import ru.fafurin.lesson6.service.db.EpisodeDBService;
import ru.fafurin.lesson6.service.db.LocationDBService;

@RestController
@AllArgsConstructor
public class DBCharactersController {

    private CharacterDBService characterDBService;
    private LocationDBService locationDBService;
    private EpisodeDBService episodeDBService;

    @GetMapping("/save-locations")
    public ResponseEntity<String> saveLocations() {
        try {
            locationDBService.saveAllLocationsToDB();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/save-characters")
    public ResponseEntity<String> saveCharacters() {
        try {
            characterDBService.saveAllCharactersToDB();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/save-episodes")
    public ResponseEntity<String> saveEpisodes() {
        try {
            episodeDBService.saveAllEpisodesToDB();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/load")
    public ResponseEntity<String> getCharacters() {
        try {
            characterDBService.saveAllCharactersToDB();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
