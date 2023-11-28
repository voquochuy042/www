package com.fit.se.models;

import com.fit.se.enums.SkillLevel;
import com.fit.se.ids.CandidateSkillID;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "candidate_skill")
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(CandidateSkillID.class)
@Builder
public class CandidateSkill implements Serializable {
    @Column(name = "skill_level", nullable = false)
    private SkillLevel skillLevel;
    @Id
    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Skill skill;
    @Id
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;
    @Column(name = "more_infos", length = 1000)
    private String moreInfo;
}
