package com.apuliadigital.corsospring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name= "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message="Il nome non può essere vuoto")
    @Column(nullable = false)
    private String title;

    private String content;
    @ManyToOne
    @JoinColumn(name= "user_id")
    @JsonIgnore
    private User user;

    public Post() {}

    public Post(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
