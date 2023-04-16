package com.example.challenge4.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "Films")

public class films {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;

    @Column(name = "filmName")
    public String filmName;

    @Column(name = "statusFilm")
    public String statusFilm;
}
