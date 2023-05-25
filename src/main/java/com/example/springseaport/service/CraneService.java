package com.example.springseaport.service;

import com.example.springseaport.dto.CargoShipDto;
import com.example.springseaport.dto.CraneDto;
import com.example.springseaport.entity.CargoShip;
import com.example.springseaport.entity.Crane;
import com.example.springseaport.entity.Schedule;
import com.example.springseaport.repository.CargoRepository;
import com.example.springseaport.repository.CargoShipRepository;
import com.example.springseaport.repository.CraneRepository;
import com.example.springseaport.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CraneService {

    private final CraneRepository craneRepository;
    private final CargoShipRepository cargoShipRepository;
    private final ScheduleRepository scheduleRepository;
    private final CargoRepository cargoRepository;

    public CraneService(CraneRepository craneRepository, CargoShipRepository cargoShipRepository, ScheduleRepository scheduleRepository, CargoRepository cargoRepository){
        this.craneRepository = craneRepository;
        this.cargoShipRepository = cargoShipRepository;
        this.scheduleRepository = scheduleRepository;
        this.cargoRepository = cargoRepository;
    }

    public List<CraneDto> getAllDto(){
        List<Crane> cranes = craneRepository.getAll();
        List<CraneDto> dtos = new ArrayList<>();
        for (Crane crane : cranes) {
            dtos.add(new CraneDto(crane.getId(), crane.getType()));
        }
        return dtos;
    }

    public void addCrane(CraneDto craneDto){
        craneRepository.add(new Crane(craneDto.getId(), craneDto.getType()));
    }

    public void deleteById(Integer id){
        craneRepository.deleteById(id);
    }

    public Queue<CargoShipDto> getQueueShips(int id){
        Queue<CargoShipDto> queue = new LinkedList<>();
        List<Schedule> schedules = sort(scheduleRepository.getAll());
        List<Schedule> schedulesById = new ArrayList<>();
        for (Schedule value : schedules) {
            if (cargoRepository.findCargoById(value.getCargoId()).getType()
                    .equals(craneRepository.findCraneById(id).getType())) {
                schedulesById.add(value);
            }
        }

        CargoShip ship;
        for (Schedule schedule : schedulesById) {
            ship = cargoShipRepository.findCargoShipById(schedule.getCargoShipId());
            queue.add(new CargoShipDto(ship.getId(), ship.getName(), ship.getCargoId()));
        }
        return queue;
    }

    private List<Schedule> sort(List<Schedule> schedules){
        schedules.sort((schedule1, schedule2) -> schedule1.getDate().compareTo(schedule2.getDate()));
        return schedules;
    }
}
