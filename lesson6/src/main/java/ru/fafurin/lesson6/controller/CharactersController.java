package ru.fafurin.lesson6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.fafurin.lesson6.model.Character;
import ru.fafurin.lesson6.service.CharactersService;

@Controller
public class CharactersController {

    @Autowired
    private CharactersService service;

    @GetMapping("/")
    public String getCharacters(@RequestParam(defaultValue = "0") int page, Model model) {
        Page<Character> characters = service.findPaginatedCharacters(page);
        model.addAttribute("characters", characters);
        model.addAttribute("currentPage", page);
        return "characters";
    }

    @GetMapping("/character/{id}")
    public String getCharacterById(@PathVariable("id") int id, Model model) {
        Character character = service.findCharacterById(id).orElseThrow();
        model.addAttribute("character", character);
        return "character-info";
    }
}
