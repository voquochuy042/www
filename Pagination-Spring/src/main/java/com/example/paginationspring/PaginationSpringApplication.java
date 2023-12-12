package com.example.paginationspring;

import com.example.paginationspring.model.Candidate;
import com.example.paginationspring.model.Experience;
import com.example.paginationspring.model.Roles;
import com.example.paginationspring.repository.CandidateRepository;
import com.example.paginationspring.repository.ExperienceRepository;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class PaginationSpringApplication {


    @Autowired
    CandidateRepository candidateRepository;
    @Autowired
    ExperienceRepository experienceRepository;

    public static void main(String[] args) {
        SpringApplication.run(PaginationSpringApplication.class, args);
    }
//    @Bean
    CommandLineRunner commandLineRunner() {
        Faker faker = new Faker();
        Random random = new Random();
        return args -> {
            List<Candidate> candidates = candidateRepository.findByRole(1);
            candidates.forEach(System.out::println);
            for (int i = 0; i < 200; i++) {
                Candidate candidate = Candidate.builder()
                        .email(faker.internet().emailAddress())
                        .phone(faker.phoneNumber().cellPhone())
                        .fullName(faker.name().fullName())
                        .build();
                candidateRepository.save(candidate);
            }
            for (int i = 0; i < 9; i++) {
                long canId = (long) random.nextInt(3 - 1) + 1;
                Experience experience = Experience.builder()
                        .role(getRandomRole())
                        .fromDate(getRandomDate())
                        .toDate(getRandomDate())
                        .companyName(faker.company().name())
                        .workDescription(faker.lorem().sentence())
                        .candidate(Candidate.builder().id(canId).build())
                        .build();
                experienceRepository.save(experience);

            }
        };
    }

    private Roles getRandomRole() {
        Roles[] roles = Roles.values();
        int randomIndex = (int) (Math.random() * roles.length);
        return roles[randomIndex];
    }

    private LocalDate getRandomDate() {
        // Generate a random date within a specific range (adjust the range as needed)
        LocalDate startDate = LocalDate.of(2000, 1, 1);
        long daysToAdd = (long) (Math.random() * ChronoUnit.DAYS.between(startDate, LocalDate.now()));
        return startDate.plusDays(daysToAdd);
    }


}
