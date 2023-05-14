package com.crud.poliza.service;

import com.crud.poliza.model.Poliza;

import java.util.List;

public interface IPolizaService {
    public List<Poliza> findAll();
    public int save(Poliza poliza);
    public int update(Poliza poliza);
    public int deleteById(int id);
}
