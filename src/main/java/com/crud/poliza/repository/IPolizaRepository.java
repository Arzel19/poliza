package com.crud.poliza.repository;

import com.crud.poliza.model.Poliza;

import java.util.List;

public interface IPolizaRepository {
    public List<Poliza> findAll();
    public int save(Poliza poliza);
    public int update(Poliza poliza);
    public int deleteById(int id);
}
