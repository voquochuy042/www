package com.example.paginationspring.controller;

import com.example.paginationspring.model.Experience;
import com.example.paginationspring.repository.ExperienceRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ExperienceController {
    private final ExperienceRepository experienceRepository;

    @GetMapping("/exp/{id}")
    public String getDetailPage(Model model, @PathVariable("id") long id) {
        List<Experience> experiences = experienceRepository.getAllByCandidate(id);
        model.addAttribute("experiences",experiences);
        return "detail-page";
    }

}
