package com.example.tuan5;

import com.example.tuan5.backend.entities.*;
import com.example.tuan5.backend.enums.SkillLevel;
import com.example.tuan5.backend.enums.SkillType;
import com.example.tuan5.backend.repositories.*;
import com.github.javafaker.Faker;
import com.neovisionaries.i18n.CountryCode;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Tuan5Application {

    public static void main(String[] args) {
        SpringApplication.run(Tuan5Application.class, args);
    }
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private CandidateRepository candidateRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private ExperienceRepository experienceRepository;
    @Autowired
    private SkillRepository skillRepository;
    @Autowired
    private CandidateSkillRepository candidateSkillRepository;
    @Autowired
    private JobSkillRepository jobSkillRepository;
    @Autowired
    private JobRepository jobRepository;
//    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Random random = new Random();
            Address address = null;
            Candidate candidate = null;
            Company company = null;
            Experience experience = null;
            Job job = null;
            Skill skill = null;
            CandidateSkill candidateSkill = null;
            JobSkill jobSkill = null;
            Faker faker = new Faker();
            for (int i = 1; i <= 100; i++) {
                address = new Address(i, faker.address().city(), CountryCode.VN, random.nextLong(1000000L, 9999999L) + "", faker.address().city(), faker.number().numberBetween(0, 1000)+"");
                candidate = new Candidate(i, faker.name().fullName(),
                        faker.internet().emailAddress(), faker.phoneNumber().cellPhone(),
                        LocalDate.of(2002, random.nextInt(1, 13), random.nextInt(1, 29)),
                        address, null, null);
                company = new Company(i, faker.company().name(), "About company " + i, address, faker.company().name().replaceAll("\\s+", "").toLowerCase() + "@gmail.com",
                        faker.phoneNumber().cellPhone(), "https://www.company" + i + ".com.vn", null);
                skill = new Skill(i, i % 3 == 0 ? SkillType.UNSPECIFIC : i % 3 == 1 ? SkillType.TECHNICAL_SKILL : SkillType.SOFT_SKILL, "Skill " + i, "Skill description " + i, null);
                addressRepository.save(address);
                candidateRepository.save(candidate);
                companyRepository.save(company);
                skillRepository.save(skill);
            }
            for (int i = 1; i <= 100; i++) {
                experience = new Experience(i, LocalDate.of(random.nextInt(1990, 2000), random.nextInt(1, 13), random.nextInt(1, 29)),
                        LocalDate.of(random.nextInt(2000, 2022), random.nextInt(1, 13), random.nextInt(1, 29)),
                        i % 2 == 0 ? "employee" : "manager", "company " + random.nextInt(100), "work description",
                        candidateRepository.findById(random.nextLong(1, 101)).get());
                experienceRepository.save(experience);
            }
            for (int i = 1; i <= 100; i++) {
                job = new Job("Job " + i, companyRepository.findById(random.nextLong(1, 101)).get(), "Description job " + i);
                jobRepository.save(job);
            }

            for (int i = 1; i <= 100; i++) {
                candidate = candidateRepository.findById(random.nextLong(1,101)).get();
                skill = skillRepository.findById(random.nextLong(1,101)).get();
                candidateSkill = new CandidateSkill(candidate, skill
                        , i%5==0? SkillLevel.BEGIN:i%5==1?SkillLevel.IMTERMEDIATE:i%5==2?SkillLevel.ADVANCED:i%5==3?SkillLevel.PROFESSIONAL:SkillLevel.MASTER,
                        "More information "+i);
                candidateSkillRepository.save(candidateSkill);
                job = jobRepository.findById(random.nextLong(1,101)).get();
                skill = skillRepository.findById(random.nextLong(1,101)).get();
                jobSkill = new JobSkill(job, skill, i % 9 == 0 ? SkillLevel.BEGIN : i % 9 == 2 ? SkillLevel.IMTERMEDIATE : i % 9 == 4 ? SkillLevel.ADVANCED : i % 9 == 6 ? SkillLevel.PROFESSIONAL : SkillLevel.MASTER,
                        "More information " + 1);
                jobSkillRepository.save(jobSkill);

            }
        };
    }
}
