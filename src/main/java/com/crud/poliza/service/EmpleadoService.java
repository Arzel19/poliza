package com.crud.poliza.service;

import com.crud.poliza.model.Empleado;
import com.crud.poliza.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService{
    @Autowired
    private IEmpleadoRepository iEmpleadoRepository;

    @Override
    public List<Empleado> findAll() {
        List<Empleado> list;
        try{
            list = iEmpleadoRepository.findAll();
        }catch (Exception ex){
            throw ex;
        }
        return list;
    }
}
