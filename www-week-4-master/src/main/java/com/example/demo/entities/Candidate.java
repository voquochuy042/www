package com.example.demo.entities;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Candidate {
    private UUID id;
    private String fullName;
    private String email;
    private String phone;
    private Address address;
    private LocalDate dob;

    public Candidate(UUID id) {
        this.id = id;
    }
}