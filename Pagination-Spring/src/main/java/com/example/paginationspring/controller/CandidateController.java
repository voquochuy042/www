package com.example.paginationspring.controller;

import com.example.paginationspring.model.Candidate;
import com.example.paginationspring.model.Roles;
import com.example.paginationspring.repository.CandidateRepository;
import com.example.paginationspring.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
@RequiredArgsConstructor
public class CandidateController {
    private final CandidateRepository candidateRepository;
    private final CandidateService candidateService;

    @GetMapping("/home")
    public String getHomePage(Model model,
                              @RequestParam("page") Optional<Integer> page,
                              @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateService.findPaginated(PageRequest.of(currentPage-1, pageSize));
        model.addAttribute("candidatePage", candidatePage);
        int totalPage = candidatePage.getTotalPages();
        if (totalPage > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage)
                    .boxed()
                    .toList();
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "index";
    }

    @GetMapping("/filter-page")
    public String getFilterPage(Model model) {
        List<Roles> roles = List.of(Roles.values());
        model.addAttribute("roles", roles);
        return "filter-page";
    }

    @GetMapping("/filter")
    public String filterCandidate(@RequestParam("role") int role, Model model) {
        System.out.println(role);
        List<Roles> roles = List.of(Roles.values());
        model.addAttribute("roles", roles);
        List<Candidate> candidates = candidateRepository.findByRole(role);
        model.addAttribute("candidates", candidates);
        return "filter-page";
    }
}
