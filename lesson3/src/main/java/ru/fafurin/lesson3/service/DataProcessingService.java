package ru.fafurin.lesson3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fafurin.lesson3.domain.User;
import ru.fafurin.lesson3.repository.UserRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataProcessingService {

    @Autowired
    private UserRepository userRepository;

    public List<User> sortUsersByAge() {
        return userRepository.getUsers().stream()
                .sorted(Comparator.comparing(User::getAge))
                .collect(Collectors.toList());
    }

    public List<User> filterUsersByAge(Integer age) {
        return userRepository.getUsers().stream()
                .filter(user -> user.getAge() > age)
                .collect(Collectors.toList());
    }

    public double calculateAverageAge() {
        return userRepository.getUsers().stream()
                .mapToInt(User::getAge)
                .average()
                .orElse(0);
    }
}
