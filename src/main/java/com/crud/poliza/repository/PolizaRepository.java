package com.crud.poliza.repository;

import com.crud.poliza.model.Poliza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PolizaRepository implements IPolizaRepository{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Poliza> findAll() {
        String SQL= "SELECT * FROM vw_polizas";
        return jdbcTemplate.query(SQL, BeanPropertyRowMapper.newInstance(Poliza.class));
    }

    @Override
    public int save(Poliza poliza) {
        String SQL= "EXEC insertarPolizas @EmpleadoGenero=?,@SKU=?,@Cantidad=?,@fecha=?";
        return jdbcTemplate.update(SQL, new Object[]{poliza.getIdEmpleado(), poliza.getSKU(),
                poliza.getCantidad(), poliza.getFecha()});

    }

    @Override
    public int update(Poliza poliza) {
        String SQL= "EXEC actualizarPoliza @IdPoliza =?, @NuevoIdEmpleado=?";
        return jdbcTemplate.update(SQL, new Object[]{poliza.getIdPoliza(), poliza.getIdEmpleado()});
    }

    @Override
    public int deleteById(int id) {
        String SQL= "EXEC borrarPoliza @IdPoliza= ?";
        return jdbcTemplate.update(SQL, new Object[]{id});
    }
}
