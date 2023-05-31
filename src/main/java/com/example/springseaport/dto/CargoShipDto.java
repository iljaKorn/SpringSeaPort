package com.example.springseaport.dto;

import com.example.springseaport.entity.Cargo;
import com.example.springseaport.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CargoShipDto {

    private Integer id;

    private String name;

    private List<Cargo> cargoList;

    private Schedule schedule;
}
