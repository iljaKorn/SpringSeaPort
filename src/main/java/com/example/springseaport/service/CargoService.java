package com.example.springseaport.service;

import com.example.springseaport.dto.CargoDto;
import com.example.springseaport.entity.Cargo;
import com.example.springseaport.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<CargoDto> getAllDto() {
        List<Cargo> cargos = cargoRepository.getAll();
        List<CargoDto> cargoDtos = new ArrayList<>();
        for (Cargo cargo : cargos) {
            cargoDtos.add(new CargoDto(cargo.getId(), cargo.getName(), cargo.getType(), cargo.getWeight()));
        }
        return cargoDtos;
    }

    public void addCargo(CargoDto cargoDto){
        cargoRepository.add(new Cargo(cargoRepository.count() + 1, cargoDto.getName(), cargoDto.getType(), cargoDto.getWeight()));
    } //не знаю насчёт Id

    public void deleteById(Integer id){
        cargoRepository.deleteById(id);
    }
}
