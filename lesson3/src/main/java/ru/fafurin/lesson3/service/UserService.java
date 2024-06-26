package ru.fafurin.lesson3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fafurin.lesson3.domain.User;

@Service
public class UserService {
    @Autowired
    private NotificationService notificationService;

    public User createUser(String name, Integer age, String email) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        user.setEmail(email);
        notificationService.notifyUser(user);
        return user;
    }
}