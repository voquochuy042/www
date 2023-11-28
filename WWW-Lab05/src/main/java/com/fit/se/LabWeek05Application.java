package com.fit.se;

import com.fit.se.enums.SkillType;
import com.fit.se.models.*;
import com.fit.se.repositories.*;
import com.neovisionaries.i18n.CountryCode;
import net.datafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class LabWeek05Application {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private ExperienceRepository experienceRepository;

    public static void main(String[] args) {
        SpringApplication.run(LabWeek05Application.class, args);
    }

//    @Bean
//    CommandLineRunner commandLineRunner() {
//        return args -> {
//            Faker faker = new Faker();
//            try {
//                for (long i = 1; i <= 20; i++) {
//                    LocalDate fromDate = faker.date().past(365, TimeUnit.DAYS).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//
//                    // Generate a random toDate within a reasonable range (adjust as needed)
//                    LocalDate toDate = fromDate.plusDays(faker.number().numberBetween(1, 30));
//
//                    Experience experience = Experience.builder()
//                            .companyName(faker.company().name())
//                            .fromDate(fromDate)
//                            .role(faker.job().title())
//                            .toDate(toDate)
//                            .workDescription(faker.lorem().sentence())
//                            .candidate(Candidate.builder().id(i).build())
//                            .build();
//                    experienceRepository.save(experience);
//                }
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//            }
//        };
//    }

}
