package com.example.springseaport.entity;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@NoArgsConstructor
@Getter
@Setter
public class CargoShip {

    private Integer id;

    private String name;

    private int cargoId;

    public CargoShip(Integer id, String name, int cargoId){
        this.id = id;
        this.name = name;
        this.cargoId = cargoId;
    }

}
