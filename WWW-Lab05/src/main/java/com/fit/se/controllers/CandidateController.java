package com.fit.se.controllers;

import com.fit.se.models.Address;
import com.fit.se.models.Candidate;
import com.fit.se.models.Experience;
import com.fit.se.repositories.AddressRepository;
import com.fit.se.repositories.CandidateRepository;
import com.fit.se.repositories.ExperienceRepository;
import com.fit.se.services.CandidateService;
import com.neovisionaries.i18n.CountryCode;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class CandidateController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
    private final CandidateService candidateService;
    private final CandidateRepository candidateRepository;
    private final AddressRepository addressRepository;
    private final ExperienceRepository experienceRepository;

    @GetMapping("/candidates")
    public String showCustomerListPaging(
            Model model,
            @RequestParam("page") Optional<Integer> page,
            @RequestParam("size") Optional<Integer> size
    ) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(6);
        Page<Candidate> candidatePage = candidateService.findPaginated(
                PageRequest.of(currentPage - 1, pageSize)
        );
        int totalPages = candidatePage.getTotalPages();
        int startPage = Math.max(1, currentPage - 2);
        int endPage = Math.min(startPage + 4, totalPages);
        model.addAttribute("candidatePage", candidatePage);
        model.addAttribute("control", "candidates");
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(startPage, endPage)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidate-page";
    }

    @GetMapping("/insert-form")
    public String showInsertForm(Model model) {
        Candidate candidate = new Candidate();
        Address address = new Address();
        candidate.setAddress(address);
        model.addAttribute("candidate", candidate);
        model.addAttribute("address", address);
        model.addAttribute("countryCodes", CountryCode.values());
        return "insert-candidate";
    }

    @PostMapping("/add-candidate")
    public String addCandidate(
            @ModelAttribute("candidate") Candidate candidate,
            @ModelAttribute("address") Address address) {
        try {
            Address addressSave = addressRepository.save(address);
            System.out.println(addressSave);
            candidate.setAddress(addressSave);
            candidateRepository.save(candidate);
            return "redirect:/candidates";
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return "redirect:/candidates";
    }

    @GetMapping("/candidate/{id}")
    public String showCandidateDetail(@PathVariable("id") long id,Model model) {
        Candidate candidate = candidateRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Not found id: " + id));
        List<Experience> experiences = experienceRepository.getExperiencesByCandidate(id);
        model.addAttribute("candidate",candidate);
        model.addAttribute("experiences",experiences);
        model.addAttribute("address",addressRepository);
        return "candidate-detail";
    }
}
