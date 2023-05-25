package com.example.springseaport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CargoDto {

    private Integer id;

    private String name;

    private String type;

    private Integer weight;
}
