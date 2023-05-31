package com.example.springseaport.dto;

import com.example.springseaport.entity.CargoShip;
import com.example.springseaport.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
public class ScheduleDto {

    private Integer id;

    private String date;

    private String time;

    private CargoShip cargoShip;
    private String parkingPeriod;

}
