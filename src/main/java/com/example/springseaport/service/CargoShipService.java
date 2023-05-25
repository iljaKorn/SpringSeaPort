package com.example.springseaport.service;

import com.example.springseaport.dto.CargoShipDto;
import com.example.springseaport.entity.CargoShip;
import com.example.springseaport.mapper.CargoShipMapper;
import com.example.springseaport.repository.CargoRepository;
import com.example.springseaport.repository.CargoShipRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargoShipService {

    private final CargoShipRepository cargoShipRepository;
    private final CargoShipMapper mapper;

    public CargoShipService(CargoShipRepository cargoShipRepository, CargoShipMapper cargoShipMapper){
        this.cargoShipRepository = cargoShipRepository;
        this.mapper = cargoShipMapper;
    }

    public List<CargoShipDto> getAllDto(){
        return cargoShipRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public CargoShipDto getCargoShipById(int id){
        Optional<CargoShip> cargoShipOptional = cargoShipRepository.findById(id);
        if (cargoShipOptional.isPresent()){
            return mapper.toDto(cargoShipOptional.get());
        } else {
            throw new IllegalArgumentException("Танкер с id: " + id + " не найден");
        }
    }

    public void addCargoShip(CargoShipDto cargoShipDto){
        CargoShip newCargoShip = mapper.toEntity(cargoShipDto);
        cargoShipRepository.save(newCargoShip);
    }

    public void deleteById(Integer id){
        Optional<CargoShip> cargoShipOptional = cargoShipRepository.findById(id);
        if(cargoShipOptional.isPresent()){
            cargoShipRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Танкер с id: " + id + " не найден");
        }

    }
}
