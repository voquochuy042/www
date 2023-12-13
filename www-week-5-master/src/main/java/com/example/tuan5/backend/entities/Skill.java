package com.example.tuan5.backend.entities;

import com.example.tuan5.backend.enums.SkillType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "skill")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", length = 20)
    private long id;
    @Column(name = "skill_type")
    private SkillType skillType;
    @Column(name = "skill_name", length = 150)
    private String skillName;
    @Column(name = "skill_desc", length = 300)
    private String skillDesc;
    @OneToMany(mappedBy = "skill", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<JobSkill> jobSkills;
}
