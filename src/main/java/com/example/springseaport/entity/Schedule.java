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
    private Date date;
    @Column(name = "time")
    private Time time;

    @OneToOne(mappedBy = "schedule")
    @JoinColumn(name = "cargoShip_id")
    private CargoShip cargoShip;
    @Column(name = "parking_period")
    private String parkingPeriod;
}
