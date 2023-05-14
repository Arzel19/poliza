package com.crud.poliza.controller;

import com.crud.poliza.model.*;
import com.crud.poliza.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/empleado")
@CrossOrigin("*")
public class EmpleadoController {
    @Autowired
    private IEmpleadoService iEmpleadoService;
    @GetMapping("/list")
    public Response list(){
        GetEmpleadoResponse getEmpleadoResponse= new GetEmpleadoResponse();
        List<Empleado> result=null;
        try{
            result= iEmpleadoService.findAll();
        }catch (Exception e){
            OtherResponse otherResponse=new OtherResponse();
            otherResponse.getMeta().setStatus("FAILURE");
            otherResponse.getData().setMensaje("Ha ocurrido un error al consultar los empleados.");
            return otherResponse;
        }
        getEmpleadoResponse.getMeta().setStatus("OK");
        getEmpleadoResponse.setData(result);
        return getEmpleadoResponse;
    }
}
