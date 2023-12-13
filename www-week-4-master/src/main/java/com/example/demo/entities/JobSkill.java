package com.example.demo.entities;
import com.example.demo.enums.Level;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Getter
public class JobSkill {
    private Job job;
    private Skill skill;
    private String moreInfos;
    private Level skillLevel;


}