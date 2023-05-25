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
public interface CargoShipMapper {
    @Mapping(target = "scheduleId", expression = "java(getScheduleId(cargoShip.getSchedule().getId()))")
    @Mapping(target = "cargoIdList", expression = "java(getCargoIds(cargoShip.getCargoList()))")
    CargoShipDto toDto(CargoShip cargoShip);
    CargoShip toEntity(CargoShipDto dto);

    default Integer getScheduleId(Schedule schedule) {
        return schedule == null ? null : schedule.getId();
    }

    default List<Integer> getCargoShipIds(List<Cargo> cargos) {
        return cargos == null ? null : cargos.stream().map(Cargo::getId).collect(Collectors.toList());
    }
}
