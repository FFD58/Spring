package ru.fafurin.lesson8.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.fafurin.lesson8.domain.Log;

public interface LogRepository extends MongoRepository<Log, ObjectId> {
}
