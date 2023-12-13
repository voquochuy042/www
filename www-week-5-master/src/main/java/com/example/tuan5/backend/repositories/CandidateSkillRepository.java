package com.example.tuan5.backend.repositories;

import com.example.tuan5.backend.entities.CandidateSkill;
import com.example.tuan5.id.CandidateSkillId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateSkillRepository extends JpaRepository<CandidateSkill, CandidateSkillId> {
}