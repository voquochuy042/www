package com.fit.se.repositories;


import com.fit.se.models.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "candidates", path = "candidates")
//public interface CandidateRepository extends PagingAndSortingRepository<Candidate, Long> {
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
