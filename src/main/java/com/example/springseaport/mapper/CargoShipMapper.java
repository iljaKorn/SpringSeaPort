package com.example.springseaport.mapper;

import com.example.springseaport.dto.CargoShipDto;
import com.example.springseaport.entity.Cargo;
import com.example.springseaport.entity.CargoShip;
import com.example.springseaport.entity.Schedule;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CargoShipMapper {

    CargoShipDto toDto(CargoShip cargoShip);
    CargoShip toEntity(CargoShipDto dto);

}
