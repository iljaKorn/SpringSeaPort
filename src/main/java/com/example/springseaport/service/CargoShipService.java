package com.example.springseaport.service;

import com.example.springseaport.dto.CargoShipDto;
import com.example.springseaport.entity.CargoShip;
import com.example.springseaport.repository.CargoRepository;
import com.example.springseaport.repository.CargoShipRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoShipService {

    private final CargoShipRepository cargoShipRepository;

    public CargoShipService(CargoShipRepository cargoShipRepository){
        this.cargoShipRepository = cargoShipRepository;
    }

    public List<CargoShipDto> getAllDto(){
        List<CargoShip> ships = cargoShipRepository.getAll();
        List<CargoShipDto> cargoShipDtos = new ArrayList<>();
        for (CargoShip ship : ships) {
            cargoShipDtos.add(new CargoShipDto(ship.getId(), ship.getName(), ship.getCargoId()));
        }
        return cargoShipDtos;
    }

    public CargoShipDto getCargoShipById(int id){
        CargoShip ship = cargoShipRepository.findCargoShipById(id);
        return new CargoShipDto(ship.getId(), ship.getName(), ship.getCargoId());
    }

    public void addCargoShip(CargoShipDto cargoShipDto){
        cargoShipRepository.add(new CargoShip(cargoShipRepository.count() + 1, cargoShipDto.getName(),
                cargoShipDto.getCargoId()));
    }

    public void deleteById(Integer id){
        cargoShipRepository.deleteById(id);
    }
}
