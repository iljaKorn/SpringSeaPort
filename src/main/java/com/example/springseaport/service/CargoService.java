package com.example.springseaport.service;

import com.example.springseaport.dto.CargoDto;
import com.example.springseaport.entity.Cargo;
import com.example.springseaport.mapper.CargoMapper;
import com.example.springseaport.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;
    private final CargoMapper mapper;

    public CargoService(CargoRepository cargoRepository, CargoMapper cargoMapper) {
        this.cargoRepository = cargoRepository;
        this.mapper = cargoMapper;
    }

    public List<CargoDto> getAllDto() {
        return cargoRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public void addCargo(CargoDto cargoDto){
        Cargo newCargo = mapper.toEntity(cargoDto);
        cargoRepository.save(newCargo);
    }

    public void deleteById(Integer id){
        Optional<Cargo> cargoOptional = cargoRepository.findById(id);
        if(cargoOptional.isPresent()){
            cargoRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Груз с id: " + id + " не найден");
        }

    }
}
