package com.example.week_1.repositories;

import com.example.week_1.entities.Log;

import java.util.Optional;

public class LogRepository extends CRUDRepository<Log, Long> {
    public Optional<Boolean> update(Log log) {
        return super.updateById(log, log.getId());
    }
}

