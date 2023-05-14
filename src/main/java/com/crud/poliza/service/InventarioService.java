package com.crud.poliza.service;

import com.crud.poliza.model.Inventario;
import com.crud.poliza.repository.IInventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventarioService implements IInventarioService{
    @Autowired
    private IInventarioRepository iInventarioRepository;
    @Override
    public List<Inventario> findAll() {
        List<Inventario> list;
        try{
            list = iInventarioRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }
}
