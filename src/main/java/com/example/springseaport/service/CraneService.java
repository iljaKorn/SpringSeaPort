package com.example.springseaport.service;

import com.example.springseaport.dto.CargoShipDto;
import com.example.springseaport.dto.CraneDto;
import com.example.springseaport.entity.CargoShip;
import com.example.springseaport.entity.Crane;
import com.example.springseaport.entity.Schedule;
import com.example.springseaport.mapper.CargoShipMapper;
import com.example.springseaport.mapper.CraneMapper;
import com.example.springseaport.repository.CargoRepository;
import com.example.springseaport.repository.CargoShipRepository;
import com.example.springseaport.repository.CraneRepository;
import com.example.springseaport.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CraneService {

    private final CraneRepository craneRepository;
    private final CargoShipRepository cargoShipRepository;
    private final ScheduleRepository scheduleRepository;
    private final CargoRepository cargoRepository;
    private final CraneMapper craneMapper;
    private final CargoShipMapper cargoShipMapper;

    public CraneService(CraneRepository craneRepository, CargoShipRepository cargoShipRepository,
                        ScheduleRepository scheduleRepository, CargoRepository cargoRepository,
                        CraneMapper craneMapper, CargoShipMapper cargoShipMapper){
        this.craneRepository = craneRepository;
        this.cargoShipRepository = cargoShipRepository;
        this.scheduleRepository = scheduleRepository;
        this.cargoRepository = cargoRepository;
        this.craneMapper = craneMapper;
        this.cargoShipMapper = cargoShipMapper;
    }

    public List<CraneDto> getAllDto(){
        return craneRepository.findAll().stream().map(craneMapper::toDto).collect(Collectors.toList());
    }

    public void addCrane(CraneDto craneDto){
        Crane newCrane = craneMapper.toEntity(craneDto);
        craneRepository.save(newCrane);
    }

    public void deleteById(Integer id){
        Optional<Crane> craneOptional = craneRepository.findById(id);
        if (craneOptional.isPresent()){
            craneRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Кран с id: " + id + " не найден");
        }
    }

    public Queue<CargoShipDto> getQueueShips(int id){
        Queue<CargoShipDto> queue = new LinkedList<>();
        List<Schedule> schedules = sort(scheduleRepository.findAll());
        List<Schedule> schedulesById = new ArrayList<>();
        for (Schedule value : schedules) {
            if (cargoRepository.findById(value.getCargoShip().getId()).get().getType()
                    .equals(craneRepository.findById(id).get().getType())) {
                schedulesById.add(value);
            }
        }

        CargoShip ship;
        for (Schedule schedule : schedulesById) {
            ship = cargoShipRepository.findById(schedule.getCargoShip().getId()).get();
            queue.add(cargoShipMapper.toDto(ship));
        }
        return queue;
    }

    private List<Schedule> sort(List<Schedule> schedules){
        schedules.sort((schedule1, schedule2) -> schedule1.getDate().compareTo(schedule2.getDate()));
        return schedules;
    }
}
