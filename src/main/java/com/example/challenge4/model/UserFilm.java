package com.example.challenge4.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="UserFilm")

public class UserFilm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
}
