package com.fit.se.repositories;

import com.fit.se.models.Job;
import org.springframework.data.jpa.repository.JpaRepository;


public interface JobRepository extends JpaRepository<Job, Long> {
    String getCompanyNameByJob(long id);
}
