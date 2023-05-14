package com.crud.poliza.repository;

import com.crud.poliza.model.Empleado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmpleadoRepository implements IEmpleadoRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Empleado> findAll() {
        String SQL= "SELECT * FROM Empleado";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Empleado.class));
    }
}
