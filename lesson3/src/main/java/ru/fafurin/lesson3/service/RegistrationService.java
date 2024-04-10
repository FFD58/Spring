package ru.fafurin.lesson3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fafurin.lesson3.domain.User;
import ru.fafurin.lesson3.repository.UserRepository;

@Service
public class RegistrationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void processRegistration(User user) {
        userRepository.save(userService.createUser(user.getName(), user.getAge(), user.getEmail()));
        notificationService.sendNotification(String.format("User %s has been successfully added to the database", user.getName()));
    }
    public void processRegistration(String name, Integer age, String email) {
        userRepository.save(userService.createUser(name, age, email));
        notificationService.sendNotification(String.format("User %s has been successfully added to the database", name));
    }
}
