package com.example.paginationspring.model;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.LifecycleState;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@NamedNativeQuery(
        name = "Candidate.findByRole",
        query = "select distinct c.* from candidate c inner join experience e\n" +
        "on c.can_id = e.can_id\n" +
        "where e.role = ?",
        resultClass = Candidate.class
)
public class Candidate {
    @Id
    @Column(name = "can_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String fullName;
    @Column(length = 15)
    private String phone;
    @OneToMany(mappedBy = "candidate",fetch = FetchType.EAGER)
    private List<Experience> experiences;

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
