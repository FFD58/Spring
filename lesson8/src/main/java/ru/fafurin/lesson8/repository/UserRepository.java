package ru.fafurin.lesson8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fafurin.lesson8.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
