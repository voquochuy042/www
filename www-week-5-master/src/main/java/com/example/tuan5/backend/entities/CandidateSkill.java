package com.example.tuan5.backend.entities;

import com.example.tuan5.backend.enums.SkillLevel;
import com.example.tuan5.id.CandidateSkillId;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "candidate_skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CandidateSkillId.class)
public class CandidateSkill {
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    @JsonIgnore
    private Candidate candidate;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Column(name = "skill_level")
    private SkillLevel skillLevel;
    @Column(name = "more_info", length = 1000)
    private String moreInfo;

    @Override
    public String toString() {
        return "CandidateSkill{" +
                "candidate=" + candidate.getId() +
                ", skill=" + skill.getId() +
                ", skillLevel=" + skillLevel +
                ", moreInfo='" + moreInfo + '\'' +
                '}';
    }
}