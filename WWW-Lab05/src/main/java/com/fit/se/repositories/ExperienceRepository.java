package com.fit.se.repositories;

import com.fit.se.models.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
    List<Experience> getExperiencesByCandidate(long id);
}