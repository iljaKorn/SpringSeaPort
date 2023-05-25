package com.example.springseaport.mapper;

import com.example.springseaport.dto.CargoDto;
import com.example.springseaport.dto.CraneDto;
import com.example.springseaport.entity.Cargo;
import com.example.springseaport.entity.Crane;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CraneMapper {
    CraneDto toDto(Crane crane);
    Crane toEntity(CraneDto dto);
}
