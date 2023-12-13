package com.example.tuan5.backend.repositories;

import com.example.tuan5.backend.entities.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Long> {
    List<Job> findAllByCompany_Id(long company_id);
}