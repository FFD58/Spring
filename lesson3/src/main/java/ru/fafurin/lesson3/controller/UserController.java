package ru.fafurin.lesson3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.fafurin.lesson3.domain.User;
import ru.fafurin.lesson3.service.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private RegistrationService service;

    @GetMapping
    public List<User> userList() {
        return service.getUserRepository().getUsers();
    }

    @PostMapping("/body")
    public String userAddFromBody(@RequestBody User user) {
        service.processRegistration(user);
        return "User added from body!";
    }

    @GetMapping("/add_user/{name}/{age}/{email}")
    public String userAddFromParam(
            @PathVariable("name") String name,
            @PathVariable("age") Integer age,
            @PathVariable("email") String email) {
        service.processRegistration(name, age, email);
        return "User added from body!";
    }
}
