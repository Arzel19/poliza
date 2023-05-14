package com.crud.poliza.model;

import lombok.Data;

import java.util.List;
@Data
public class GetEmpleadoResponse extends Response{
    Meta meta=new Meta();
    List<Empleado> data;
}
