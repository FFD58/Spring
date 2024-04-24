package ru.fafurin.lesson6.controller.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fafurin.lesson6.service.DBService;

@RestController
public class DBCharactersController {

    @Autowired
    private DBService dbService;

    @GetMapping("/load")
    public ResponseEntity<String> getCharacters() {
        try {
            dbService.saveAllCharactersToDB();
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (JsonProcessingException e) {
            return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
        }
    }
}
