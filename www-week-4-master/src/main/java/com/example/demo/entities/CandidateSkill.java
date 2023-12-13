package com.example.demo.entities;

import com.example.demo.enums.Level;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CandidateSkill {
    private Candidate candidate;
    private Skill skill;
    private String moreInfos;
    private Level skillLevel;


}