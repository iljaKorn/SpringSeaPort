package com.example.springseaport.controller;

import com.example.springseaport.dto.CargoShipDto;
import com.example.springseaport.service.CargoService;
import com.example.springseaport.service.CargoShipService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CargoShipController {

    private final CargoShipService service;

    public CargoShipController(CargoShipService service){
        this.service = service;
    }
    @GetMapping("/cargoships")
    public List<CargoShipDto> getAllCargoShip(){
        return service.getAllDto();
    }
    @PostMapping("/cargoship/add")
    public void addNewCargoShip(@RequestBody CargoShipDto cargoShipDto){
        service.addCargoShip(cargoShipDto);
    }
    @DeleteMapping("/cargoship/delete/{id}")
    public void deleteCargoShip(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/cargoship/{id}")
    public CargoShipDto getCargoShipById(@PathVariable int id){
        return service.getCargoShipById(id);
    }

}
