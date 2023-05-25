package com.example.springseaport.repository;

import com.example.springseaport.entity.Cargo;
import com.example.springseaport.entity.Crane;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CraneRepository {

    private final JdbcTemplate jdbcTemplate;

    public CraneRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Crane> getAll(){
        try {
            return jdbcTemplate.query(
                    "SELECT * FROM crane",
                    BeanPropertyRowMapper.newInstance(Crane.class));
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public Crane findCraneById(Integer id){
        try {
            return jdbcTemplate.queryForObject(
                    "SELECT * FROM crane WHERE id=?",
                    BeanPropertyRowMapper.newInstance(Crane.class), id);
        } catch (IncorrectResultSizeDataAccessException e) {
            return null;
        }
    }

    public void deleteById(int id){
        jdbcTemplate.update("DELETE FROM crane WHERE id=?", id);
    }

    public void add(Crane crane){
        jdbcTemplate.update("INSERT INTO crane (id, type) VALUES(?,?)",
                crane.getId(), crane.getType());
    }

    public Integer count(){
        return jdbcTemplate.queryForObject("SELECT COUNT(1) FROM crane", Integer.class);
    }
}
