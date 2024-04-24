package ru.fafurin.lesson6.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import ru.fafurin.lesson6.model.Character;
import ru.fafurin.lesson6.repository.CharacterRepository;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLConnection;

@Service
@AllArgsConstructor
public class DBService {

    private final Environment environment;

    private final CharacterRepository repository;

    public void saveAllCharactersToDB() throws JsonProcessingException {
        int charactersCount = getCharactersCount();
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 1; i <= charactersCount; i++) {
            Character character = mapper.readValue(downloadWebPage(environment.getProperty("CHARACTER_API") + i), Character.class);
            repository.save(character);
        }
    }

    public int getCharactersCount() {
        String res = downloadWebPage(environment.getProperty("CHARACTER_API"));
        res = res.substring(res.indexOf("count"), res.indexOf("pages"));
        res = res.replaceAll("[^0-9]+", "");
        return Integer.parseInt(res);
    }

    private String downloadWebPage(String url) {
        StringBuilder res = new StringBuilder();
        String line;
        try {
            URLConnection urlConnection = new URI(url).toURL().openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                res.append(line);
            }
        } catch (IOException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Record " + res + " successfully downloaded...");
        return res.toString();
    }
}
