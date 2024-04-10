package ru.fafurin.lesson2.sevice;

import org.springframework.stereotype.Service;
import ru.fafurin.lesson2.model.User;
import ru.fafurin.lesson2.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.update(user);
    }

    public void deleteById(Integer id) {
        userRepository.deleteById(id);
    }
}