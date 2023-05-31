package com.example.springseaport.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private String date;
    @Column(name = "time")
    private String time;

    @OneToOne(mappedBy = "schedule", fetch = FetchType.LAZY)
    private CargoShip cargoShip;
    @Column(name = "parking_period")
    private String parkingPeriod;
}
