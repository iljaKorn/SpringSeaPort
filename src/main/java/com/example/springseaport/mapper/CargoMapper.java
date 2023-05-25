package com.example.springseaport.mapper;

import com.example.springseaport.dto.CargoDto;
import com.example.springseaport.entity.Cargo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CargoMapper {
    CargoDto toDto(Cargo cargo);
    Cargo toEntity(CargoDto dto);

}
