package com.example.tuan5.backend.entities;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "job")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "job_id", length = 20)
    private long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "company")
    private Company company;
    @Column(name = "job_desc", length = 2000)
    private String description;
    @OneToMany(mappedBy = "job", fetch = FetchType.LAZY)
    private List<JobSkill> jobSkills;

    public Job(String name, Company company, String description) {
        this.name = name;
        this.company = company;
        this.description = description;
    }
}