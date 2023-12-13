package com.example.tuan5.id;

import java.io.Serializable;
import java.util.Objects;

public class CandidateSkillId implements Serializable {
    private long candidate;
    private long skill;
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CandidateSkillId that)) return false;
        return Objects.equals(candidate, that.candidate) && Objects.equals(skill, that.skill);
    }
    @Override
    public int hashCode() {
        return Objects.hash(candidate, skill);
    }
}