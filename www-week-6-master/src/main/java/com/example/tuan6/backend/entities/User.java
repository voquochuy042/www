package com.example.tuan6.backend.entities;
import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private long id;
    @Column(name = "first_name", length = 50)
    private String firstName;
    @Column(name = "middle_name", length = 50)
    private String middleName;
    @Column(name = "last_name", length = 50)
    private String lastName;
    private String mobile;
    private String email;
    @Column(name = "password_hash", length = 32)
    private String passwordHash;
    @Column(name = "registered_at", length = 6)
    private LocalDateTime registeredAt;
    @Lob
    @Column(columnDefinition = "text")
    private String intro;
    @Column(name = "last_login", length = 6)
    private LocalDateTime lastLogin;
    @Lob
    @Column(columnDefinition = "text")
    private String profile;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Post> post;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<PostComment> comments;

    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, String intro, String profile) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registeredAt = LocalDateTime.now();
        this.intro = intro;
        this.profile = profile;
    }
}