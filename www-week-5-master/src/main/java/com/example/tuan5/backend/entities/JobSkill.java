package com.example.tuan5.backend.entities;

import com.example.tuan5.backend.enums.SkillLevel;
import com.example.tuan5.id.JobSkillId;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "job_skill")
@Data
@AllArgsConstructor
@NoArgsConstructor
@IdClass(JobSkillId.class)
public class JobSkill implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;
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
        return "JobSkill{" +
                "job=" + job.getId() +
                ", skill=" + skill.getId() +
                ", skillLevel=" + skillLevel +
                ", moreInfo='" + moreInfo + '\'' +
                '}';
    }
}
