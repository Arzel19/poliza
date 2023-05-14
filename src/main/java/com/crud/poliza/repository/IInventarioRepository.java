package com.crud.poliza.repository;

import com.crud.poliza.model.Inventario;

import java.util.List;

public interface IInventarioRepository {
    public List<Inventario> findAll();
}
