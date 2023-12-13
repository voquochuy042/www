package com.example.demo.entities;

import lombok.*;

import java.util.UUID;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private UUID id;
    private Company company;
    private String description;
    private String name;

    public Job(UUID id) {
        this.id = id;
    }
}