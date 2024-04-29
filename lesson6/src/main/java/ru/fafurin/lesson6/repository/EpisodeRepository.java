package ru.fafurin.lesson6.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fafurin.lesson6.model.Episode;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
}
