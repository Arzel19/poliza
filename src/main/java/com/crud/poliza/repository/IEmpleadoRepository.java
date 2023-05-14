package com.crud.poliza.repository;

import com.crud.poliza.model.Empleado;

import java.util.List;

public interface IEmpleadoRepository {
    public List<Empleado> findAll();
}
