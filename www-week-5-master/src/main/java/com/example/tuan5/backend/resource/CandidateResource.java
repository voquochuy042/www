package com.example.tuan5.backend.resource;

import com.example.tuan5.backend.entities.Candidate;
import com.example.tuan5.backend.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class CandidateResource {
    @Autowired
    private CandidateRepository repository;
    @GetMapping("/candidates")
    public ResponseEntity<List<Candidate>> getAll(){
        List<Candidate> candidates = repository.findAll();
        if(candidates.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Candidate>>(candidates, HttpStatus.OK);
    }
    @GetMapping("/candidates/{id}")
    public Optional<Candidate> findCandidate(@PathVariable("id") long id){
        return repository.findById(id);
    }
}