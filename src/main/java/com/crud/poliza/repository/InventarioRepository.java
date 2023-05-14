package com.crud.poliza.repository;


import com.crud.poliza.model.Inventario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class InventarioRepository implements IInventarioRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Inventario> findAll() {
        String SQL= "SELECT * FROM Inventario";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Inventario.class));
    }
}
