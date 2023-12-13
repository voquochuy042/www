package com.example.demo.interf;

import com.example.demo.entities.Skill;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InterfaceSkill {
    public boolean save(Skill skill);

    public boolean update(Skill skill);
    public boolean detele(UUID uuid);

    public Optional<Skill> getByID(UUID uuid);

    public List<Skill> getAll();
}
