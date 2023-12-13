package com.example.week_1.services;

import com.example.week_1.entities.Log;
import com.example.week_1.repositories.LogRepository;

import java.util.Optional;

public class LogServices {
    private final LogRepository logRepository;

    public LogServices() {
        logRepository = new LogRepository();
    }

    public boolean add(Log log) {
        return logRepository.add(log);
    }

    public Optional<Boolean> update(Log log) {
        return logRepository.update(log);
    }
}
