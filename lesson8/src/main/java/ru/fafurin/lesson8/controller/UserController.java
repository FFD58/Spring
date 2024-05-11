package ru.fafurin.lesson8.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.fafurin.lesson8.aspect.Logged;
import ru.fafurin.lesson8.domain.User;
import ru.fafurin.lesson8.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @Logged
    @GetMapping
    public List<User> list() {
        return userService.getAllUsers();
    }

    @Logged
    @PostMapping("/new")
    public String saveUser(@RequestBody User user) {
        userService.createUser(user);
        return String.format("User with id %d saved", user.getId());
    }
}
