package com.fit.se.repositories;


import com.fit.se.ids.CandidateSkillID;
import com.fit.se.models.CandidateSkill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillID> {
}