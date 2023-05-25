package com.example.springseaport.service;

import com.example.springseaport.dto.ScheduleDto;
import com.example.springseaport.entity.Schedule;
import com.example.springseaport.mapper.ScheduleMapper;
import com.example.springseaport.repository.CargoRepository;
import com.example.springseaport.repository.CargoShipRepository;
import com.example.springseaport.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper mapper;

    public ScheduleService(ScheduleRepository scheduleRepository, ScheduleMapper scheduleMapper){
        this.scheduleRepository = scheduleRepository;
        this.mapper = scheduleMapper;
    }

    public List<ScheduleDto> getAllDto(){
        return scheduleRepository.findAll().stream().map(mapper::toDto).collect(Collectors.toList());
    }

    public void addSchedule(ScheduleDto scheduleDto){
        Schedule newSchedule = mapper.toEntity(scheduleDto);
        scheduleRepository.save(newSchedule);
    }

    public void deleteById(int id){
        Optional<Schedule> scheduleOptional = scheduleRepository.findById(id);
        if(scheduleOptional.isPresent()){
            scheduleRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Расписание с id: " + id + " не найдено");
        }

    }

}
