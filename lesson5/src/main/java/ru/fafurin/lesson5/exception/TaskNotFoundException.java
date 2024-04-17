package ru.fafurin.lesson5.exception;

public class TaskNotFoundException extends RuntimeException {
    public TaskNotFoundException(Long id) {
        super(String.format("Task with id %d not found", id));
    }
}
