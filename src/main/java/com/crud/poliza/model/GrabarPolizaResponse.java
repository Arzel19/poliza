package com.crud.poliza.model;

import lombok.Data;

@Data
public class GrabarPolizaResponse extends Response{
    Meta meta=new Meta();
    Poliza data;
}