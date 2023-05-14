package com.crud.poliza.model;

import lombok.Data;

import java.util.List;
@Data
public class GetInventarioResponse extends Response{
    Meta meta=new Meta();
    List<Inventario> data;
}
