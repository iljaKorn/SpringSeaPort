package com.example.springseaport.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CargoShipDto {

    private Integer id;

    private String name;

    private Integer cargoId;
}
