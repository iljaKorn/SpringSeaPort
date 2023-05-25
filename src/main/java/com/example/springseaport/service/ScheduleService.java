package com.example.springseaport.service;

import com.example.springseaport.dto.ScheduleDto;
import com.example.springseaport.entity.Schedule;
import com.example.springseaport.repository.CargoRepository;
import com.example.springseaport.repository.CargoShipRepository;
import com.example.springseaport.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository){
        this.scheduleRepository = scheduleRepository;
    }

    public List<ScheduleDto> getAllDto(){
        List<Schedule> schedules = scheduleRepository.getAll();
        List<ScheduleDto> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            dtos.add(new ScheduleDto(schedule.getId(), schedule.getDate(), schedule.getTime(), schedule.getCargoShipId(), schedule.getCargoId(), schedule.getParkingPeriod()));
        }
        return dtos;
    }

    public void addSchedule(ScheduleDto scheduleDto){
        scheduleRepository.add(new Schedule(scheduleDto.getId(), scheduleDto.getDate(), scheduleDto.getTime(),
                scheduleDto.getCargoShipId(),
                scheduleDto.getCargoId(), scheduleDto.getParkingPeriod()));

    }

    public void deleteById(int id){
        scheduleRepository.deleteById(id);
    }

}
