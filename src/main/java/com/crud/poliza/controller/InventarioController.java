package com.crud.poliza.controller;

import com.crud.poliza.model.GetInventarioResponse;
import com.crud.poliza.model.Inventario;
import com.crud.poliza.model.OtherResponse;
import com.crud.poliza.model.Response;
import com.crud.poliza.service.IInventarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/inventario")
@CrossOrigin("*")
public class InventarioController {
    @Autowired
    private IInventarioService iInventarioService;
    @GetMapping("/list")
    public Response list(){
        GetInventarioResponse getInventarioResponse= new GetInventarioResponse();
        List<Inventario> result=null;
        try{
            result= iInventarioService.findAll();
        }catch (Exception e){
            OtherResponse otherResponse=new OtherResponse();
            otherResponse.getMeta().setStatus("FAILURE");
            otherResponse.getData().setMensaje("Ha ocurrido un error al consultar inventario.");
            return otherResponse;
        }
        getInventarioResponse.getMeta().setStatus("OK");
        getInventarioResponse.setData(result);
        return getInventarioResponse;
    }
}
