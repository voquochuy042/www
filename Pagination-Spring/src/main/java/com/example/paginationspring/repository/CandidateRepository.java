package com.example.paginationspring.repository;

import com.example.paginationspring.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {
    List<Candidate> findByRole(int role);
}
