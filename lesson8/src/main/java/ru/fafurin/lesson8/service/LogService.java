package ru.fafurin.lesson8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fafurin.lesson8.domain.Log;
import ru.fafurin.lesson8.repository.LogRepository;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    public void createLog(String method, String result) {
        Log log = logRepository.save(new Log(method, result));
        log.print();
    }
}
