package com.example.springseaport.entity;

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
public class Schedule {

    private Integer id;

    private Date date;

    private Time time;

    private int cargoShipId;

    private int cargoId;

    private String parkingPeriod;
}
