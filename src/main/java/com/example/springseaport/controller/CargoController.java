package com.example.springseaport.controller;

import com.example.springseaport.dto.CargoDto;
import com.example.springseaport.service.CargoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CargoController {

    private final CargoService service;

    private CargoController(CargoService service){
        this.service = service;
    }
    @GetMapping("/cargos")
    public List<CargoDto> getAllCargo(){
        return service.getAllDto();
    }
    @PostMapping("/cargo/add")
    public void addNewCargo(@RequestBody CargoDto cargoDto){
        service.addCargo(cargoDto);
    }

    @DeleteMapping("/cargo/delete/{id}")
    public void deleteCargo(@PathVariable int id) {
        service.deleteById(id);
    }

}
