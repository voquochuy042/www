package com.example.demo.service;

import com.example.demo.entities.Skill;
import com.example.demo.repository.SkillRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class SkillService {
    private final SkillRepositoryImpl skillRepository;
    @Autowired
    public SkillService(SkillRepositoryImpl skillRepository) {
        this.skillRepository = skillRepository;
    }
    public boolean save(Skill skill) {
        return skillRepository.save(skill);
    }
    public boolean update(Skill skill) {
        return skillRepository.save(skill);
    }
    public boolean delete(UUID uuid) {
        return skillRepository.detele(uuid);
    }
    public Optional<Skill> getByID(UUID uuid) {
        return skillRepository.getByID(uuid);
    }
    public List<Skill> getAll() {
        return skillRepository.getAll();
    }
}
