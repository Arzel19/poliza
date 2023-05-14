package com.crud.poliza.model;

import lombok.Data;

import java.util.List;
@Data
public class GetPolizaResponse extends Response{
    Meta meta=new Meta();
    List<Poliza> data;
}