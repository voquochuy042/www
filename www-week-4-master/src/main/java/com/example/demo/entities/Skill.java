package com.example.demo.entities;

import com.example.demo.enums.Type;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Skill {
    private UUID id;
    private String description;
    private String name;
    private Type type;

    public Skill(UUID id) {
        this.id = id;
    }
}