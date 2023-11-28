package com.fit.se.models;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@NamedQueries(
        {
                @NamedQuery(
                        name = "Job.getCompanyNameByJob",
                        query = "select distinct c.name from Job j inner join Company c on c.id = j.company.id where j.id =: id"
                )
        }
)
public class Job implements Serializable {
    @Id
    @Column(name = "job_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "job_name", nullable = false)
    private String name;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "com_id")
    private Company company;
    @OneToMany(mappedBy = "job", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<JobSkill> jobSkills;
    @Column(name = "job_desc", length = 2000, nullable = false)
    private String description;

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company=" + company.getId() +
                ", description='" + description + '\'' +
                '}';
    }
}
