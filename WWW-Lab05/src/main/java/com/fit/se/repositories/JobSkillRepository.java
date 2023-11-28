package com.fit.se.repositories;

import com.fit.se.ids.JobSkillID;
import com.fit.se.models.JobSkill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobSkillRepository extends JpaRepository<JobSkill, JobSkillID> {
    List<JobSkill> getSkillForJob(long id);
}