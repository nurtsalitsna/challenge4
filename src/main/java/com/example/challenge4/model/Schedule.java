package com.example.challenge4.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int scheduleId;

    @Column(name = "tanggalTayang")
    private Date tanggalTayang;
    @Column(name = "filmId")
    private int filmId;
    @Column(name = "jadwalMulai")
    private Time jadwalMulai;
    @Column(name = "jadwalSelesai")
    private Time jadwalSelesai;

    @Column(name = "harga")
    private int harga;
}
