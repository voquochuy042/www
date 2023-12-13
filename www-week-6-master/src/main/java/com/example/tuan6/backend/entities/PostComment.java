package com.example.tuan6.backend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "post_comment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 20)
    private long id;
    @Column(length = 100)
    private String title;
    private boolean published;
    @Lob
    @Column(columnDefinition = "text")
    private String content;
    @Column(name = "published_at", length = 6)
    private LocalDateTime publishedAt;
    @Column(name = "created_at", length = 6)
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private PostComment postComment;
    @OneToMany(mappedBy = "postComment", cascade = CascadeType.ALL)
    private Set<PostComment> postComments;

    public PostComment(String title, String content, LocalDateTime publishedAt, Post post, User user, PostComment postComment) {
        this.title = title;
        this.published = true;
        this.content = content;
        this.publishedAt = publishedAt;
        this.createdAt = LocalDateTime.now();
        this.post = post;
        this.user = user;
        this.postComment = postComment;
    }



}
