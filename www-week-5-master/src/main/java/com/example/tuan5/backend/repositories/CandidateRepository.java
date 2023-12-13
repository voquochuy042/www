package com.example.tuan5.backend.repositories;

import com.example.tuan5.backend.entities.Candidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

}