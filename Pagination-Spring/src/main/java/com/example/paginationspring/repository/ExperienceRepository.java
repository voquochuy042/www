package com.example.paginationspring.repository;

import com.example.paginationspring.model.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExperienceRepository extends JpaRepository<Experience,Long> {
    List<Experience> getAllByCandidate(long id);
}
