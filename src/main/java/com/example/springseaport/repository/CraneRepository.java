package com.example.springseaport.repository;

import com.example.springseaport.entity.Cargo;
import com.example.springseaport.entity.Crane;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface CraneRepository extends JpaRepository<Crane, Integer> {
}
