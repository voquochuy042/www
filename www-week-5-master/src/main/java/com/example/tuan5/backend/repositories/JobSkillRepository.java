package com.example.tuan5.backend.repositories;

import com.example.tuan5.backend.entities.JobSkill;
import com.example.tuan5.id.JobSkillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillId> {
}