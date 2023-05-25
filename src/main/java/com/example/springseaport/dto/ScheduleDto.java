package com.example.springseaport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
public class ScheduleDto {

    private Integer id;

    private Date date;

    private Time time;

    private Integer cargoShipId;
    private String parkingPeriod;

}
