package com.example.springseaport.controller;

import com.example.springseaport.dto.CargoShipDto;
import com.example.springseaport.dto.CraneDto;
import com.example.springseaport.entity.CargoShip;
import com.example.springseaport.service.CraneService;
import org.springframework.web.bind.annotation.*;

import java.util.Queue;

@RestController
public class CraneController {

    private final CraneService service;

    public CraneController(CraneService service){
        this.service = service;
    }
    @PostMapping("/crane/add")
    public void addNewCrane(@RequestBody CraneDto craneDto){
        service.addCrane(craneDto);
    }

    @DeleteMapping("/crane/delete/{id}")
    public void deleteCrane(@PathVariable int id) {
        service.deleteById(id);
    }

    @GetMapping("/crane/queue/{id}")
    public Queue<CargoShipDto> getQueue(@PathVariable int id) {
        return service.getQueueShips(id);
    }

}
