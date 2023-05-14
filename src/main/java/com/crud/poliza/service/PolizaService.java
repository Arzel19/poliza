package com.crud.poliza.service;

import com.crud.poliza.model.Poliza;
import com.crud.poliza.repository.IPolizaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PolizaService implements IPolizaService{
    @Autowired
    private IPolizaRepository iPolizaRepository;

    @Override
    public List<Poliza> findAll() {
        List<Poliza> list;
        try{
            list = iPolizaRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }

    @Override
    public int save(Poliza poliza) {
        int row;
        try{
            row = iPolizaRepository.save(poliza);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int update(Poliza poliza) {
        int row;
        try{
            row = iPolizaRepository.update(poliza);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }

    @Override
    public int deleteById(int id) {
        int row;
        try{
            row = iPolizaRepository.deleteById(id);
        }catch (Exception ex){
            throw ex;
        }
        return row;
    }
}
