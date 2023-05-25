package com.example.springseaport.mapper;

import com.example.springseaport.dto.CargoShipDto;
import com.example.springseaport.entity.Cargo;
import com.example.springseaport.entity.CargoShip;
import com.example.springseaport.entity.Schedule;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {
    @Mapping(target = "cargoShipId", expression = "java(getCargoShipId(cargoShip.getId()))")
    CargoShipDto toDto(CargoShip cargoShip);
    CargoShip toEntity(CargoShipDto dto);

    default Integer getCargoShipId(CargoShip cargoShip) {
        return cargoShip == null ? null : cargoShip.getId();
    }

}