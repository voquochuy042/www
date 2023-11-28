package com.fit.se.services;

import com.fit.se.models.Job;
import com.fit.se.models.Skill;
import com.fit.se.repositories.SkillRepository;
import com.fit.se.util.PageRender;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {
    private final SkillRepository skillRepository;

    public Page<Skill> findPaginated(Pageable pageable) {
        int pageSize = pageable.getPageSize();
        int currentPage = pageable.getPageNumber();
        int startItem = currentPage * pageSize;
        List<Skill> jobs = skillRepository.findAll();
        PageRender<Skill> pageRender = new PageRender<>();
        List<Skill> list = pageRender.getPageOfModel(jobs.size(), startItem, pageSize, jobs);
        return new PageImpl<>(list, PageRequest.of(currentPage, pageSize), jobs.size());
    }
}
