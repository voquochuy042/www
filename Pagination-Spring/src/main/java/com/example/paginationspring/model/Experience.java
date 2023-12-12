package com.example.paginationspring.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@NamedQueries({
        @NamedQuery(name = "Experience.getAllByCandidate",
        query = "select e from Experience  e where e.candidate.id =: id"
        )
})
public class Experience {
    @Id
    @Column(name = "exp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "from_date")
    private LocalDate fromDate;
    @Column(name = "work_desc")
    private String workDescription;
    @Column(columnDefinition = "tinyint(4)")
    private Roles role;
    @Column(name = "company")
    private String companyName;
    @Column(name = "to_date")
    private LocalDate toDate;
    @ManyToOne
    @JoinColumn(name = "can_id")
    private Candidate candidate;

}
