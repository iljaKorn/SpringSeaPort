package com.example.springseaport.repository;

import com.example.springseaport.entity.Cargo;
import com.example.springseaport.entity.CargoShip;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CargoShipRepository {

    private final JdbcTemplate jdbcTemplate;

    public CargoShipRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<CargoShip> getAll(){
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM cargoShip",
                    BeanPropertyRowMapper.newInstance(CargoShip.class));
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public CargoShip findCargoShipById(Integer id){
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM cargoShip WHERE id=?",
                    BeanPropertyRowMapper.newInstance(CargoShip.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public CargoShip findCargoShipByName(String name){
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM cargoShip WHERE name=?",
                    BeanPropertyRowMapper.newInstance(CargoShip.class), name);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void deleteById(int id){
        jdbcTemplate.update("DELETE FROM cargoShip WHERE id=?", id);
    }

    public void deleteByName(String name){
        jdbcTemplate.update("DELETE FROM cargoShip WHERE name=?", name);
    }

    public void add(CargoShip ship){
        jdbcTemplate.update("INSERT INTO cargoShip ("+
                        "id, name, cargoId) VALUES (?,?,?)",
                ship.getId(), ship.getName(), ship.getCargoId());
    }

    public int count(){
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM cargoShip", Integer.class);
    }
}
