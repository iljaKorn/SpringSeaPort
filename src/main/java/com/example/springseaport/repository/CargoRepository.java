package com.example.springseaport.repository;

import com.example.springseaport.entity.Cargo;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CargoRepository {

    private final JdbcTemplate jdbcTemplate;

    public CargoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Cargo> getAll(){
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM cargo",
                    BeanPropertyRowMapper.newInstance(Cargo.class));
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public Cargo findCargoById(Integer id){
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM cargo WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Cargo.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void deleteById(Integer id){
        jdbcTemplate.update("DELETE FROM cargo WHERE id=?", id);
    }

    public void deleteAll(){
        jdbcTemplate.update("DELETE from cargo");
    }

    public void add(Cargo cargo){
        jdbcTemplate.update("INSERT INTO cargo (id, name, type, weight) VALUES(?,?,?,?)",
                cargo.getId(), cargo.getName(), cargo.getType(), cargo.getWeight());
    }
    public int count(){
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM cargo", Integer.class);
    }
}
