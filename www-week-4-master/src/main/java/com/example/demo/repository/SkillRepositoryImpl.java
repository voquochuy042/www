package com.example.demo.repository;

import com.example.demo.entities.Skill;
import com.example.demo.interf.InterfaceSkill;
import com.example.demo.mapper.SkillMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class SkillRepositoryImpl implements InterfaceSkill {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public SkillRepositoryImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public boolean save(Skill skill) {
        String sqlQuery = "insert into skill(skill_id, skill_description, skill_name, type) values (?, ?, ?, ?)";

        int result = jdbcTemplate.update(sqlQuery, skill.getId(), skill.getDescription(),  skill.getName(), skill.getType().getTypeNum());
        return result > 0;
    }

    @Override
    public boolean update(Skill skill) {
        String sqlQuery = "update skill set skill_name = ?, skill_description = ?, type = ? where skill_id = ?";
        int result = jdbcTemplate.update(sqlQuery, skill.getName(), skill.getDescription(), skill.getType().getTypeNum(), skill.getId());
        return result > 0;
    }

    @Override
    public boolean detele(UUID uuid) {
        String sqlQuery = "delete from skill where skill_id = ?";
        int result = jdbcTemplate.update(sqlQuery, uuid);
        return result > 0;
    }

    @Override
    public Optional<Skill> getByID(UUID uuid) {
        String sqlQuery = "select * from skill where skill_id = ?";
        Skill skill = jdbcTemplate.queryForObject(sqlQuery, new SkillMapper(), uuid);
        return skill != null ? Optional.of(skill) : Optional.empty();
    }

    @Override
    public List<Skill> getAll() {
        String sqlQuery = "select * from skill";
        return jdbcTemplate.query(sqlQuery, new SkillMapper());
    }
}
