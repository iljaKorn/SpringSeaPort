package com.example.springseaport.repository;

import com.example.springseaport.dto.ScheduleDto;
import com.example.springseaport.entity.Cargo;
import com.example.springseaport.entity.Schedule;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ScheduleRepository {

    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Schedule> getAll(){
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM schedule",
                    BeanPropertyRowMapper.newInstance(Schedule.class));
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public Schedule findScheduleById(Integer id){
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM schedule WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Schedule.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public Schedule getScheduleByCargoShipId(Integer id){
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM schedule WHERE cargoShipId=?",
                    BeanPropertyRowMapper.newInstance(Schedule.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void deleteById(int id){
        jdbcTemplate.update("DELETE FROM schedule WHERE id=?", id);
    }

    public void add(Schedule schedule){
        jdbcTemplate.update("INSERT INTO schedule (id, date, time, cargoShipId, cargoId, parkingPeriod) VALUES(?,?,?,?,?,?)",
                schedule.getId(), schedule.getDate(), schedule.getTime(), schedule.getCargoShipId(), schedule.getCargoId(), schedule.getParkingPeriod());
    }

    public Integer count(){
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM schedule", Integer.class);
    }
}
