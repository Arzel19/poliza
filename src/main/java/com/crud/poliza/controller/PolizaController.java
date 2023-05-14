package com.crud.poliza.controller;

import com.crud.poliza.model.*;
import com.crud.poliza.service.IPolizaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/poliza")
@CrossOrigin("*")
public class PolizaController {
    @Autowired
    private IPolizaService iPolizaService;

    @GetMapping("/list")
    public Response list(){
        GetPolizaResponse getResponse= new GetPolizaResponse();
        List<Poliza> result=null;
        try{
            result= iPolizaService.findAll();
        }catch (Exception e){
            OtherResponse otherResponse=new OtherResponse();
            otherResponse.getMeta().setStatus("FAILURE");
            otherResponse.getData().setMensaje("Ha ocurrido un error al consultar las póliza.");
            return otherResponse;
        }
        getResponse.getMeta().setStatus("OK");
        getResponse.setData(result);
        return getResponse;
    }
    @PostMapping("/save")
    public Response save(@RequestBody Poliza poliza){
        GrabarPolizaResponse grabarPolizaResponse = new GrabarPolizaResponse();
        int result;
        try {
            result = iPolizaService.save(poliza);
        }catch(Exception e){
            OtherResponse otherResponse=new OtherResponse();
            otherResponse.getMeta().setStatus("FAILURE");
            otherResponse.getData().setMensaje("Ha ocurrido un error en los grabados de póliza.");
            return otherResponse;
        }
        if (result==-1){
            var polizas= iPolizaService.findAll();
            Poliza polizaInsertada=polizas.get(polizas.size()-1);
            grabarPolizaResponse.getMeta().setStatus("OK");
            grabarPolizaResponse.setData(polizaInsertada);
        }
        return grabarPolizaResponse;
    }

    @PostMapping("/update")
    public Response update(@RequestBody Poliza poliza){
        OtherResponse otherResponse=new OtherResponse();
        int result;
        try{
            result= iPolizaService.update(poliza);
        }catch(Exception e){
            otherResponse.getMeta().setStatus("FAILURE");
            otherResponse.getData().setMensaje("Ha ocurrido un error al intentar actualizar la póliza.");
            return otherResponse;
        }
        if (result==-1){
            otherResponse.getMeta().setStatus("OK");
            otherResponse.getData().setMensaje("Se actualizó correctamente la poliza "+poliza.getIdPoliza());
        }
        return otherResponse;
    }

    @GetMapping("/delete/{id}")
    public Response delete(@PathVariable int id){
        OtherResponse otherResponse = new OtherResponse();
        int result;
        try {
            result = iPolizaService.deleteById(id);
        }catch(Exception e){
            otherResponse.getMeta().setStatus("FAILURE");
            otherResponse.getData().setMensaje("Ha ocurrido un error al intentar eliminar la póliza.");
            return otherResponse;
        }
        if (result==-1){
            otherResponse.getMeta().setStatus("OK");
            otherResponse.getData().setMensaje("Se eliminó correctamente la poliza "+id);
        }
        return otherResponse;
    }
}
