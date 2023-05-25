package com.example.springseaport.controller;

import com.example.springseaport.dto.ScheduleDto;
import com.example.springseaport.repository.ScheduleRepository;
import com.example.springseaport.service.ScheduleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

@RestController
public class ScheduleController {

    private final ScheduleService service;

    public ScheduleController(ScheduleService service){
        this.service = service;
    }
    @GetMapping("/shedules")
    public List<ScheduleDto> getAllSchedule(){
        return service.getAllDto();
    }
    @PostMapping("/schedule/add")
    public void addNewSchedule(@RequestBody ScheduleDto scheduleDto){
        service.addSchedule(scheduleDto);
    }

}
