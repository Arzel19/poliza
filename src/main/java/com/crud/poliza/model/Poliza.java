package com.crud.poliza.model;

import lombok.Data;

@Data
public class Poliza {
    int IdPoliza;
    int IdEmpleado;
    String Nombre;
    String Apellido;
    int SKU;
    String Producto;
    int Cantidad;
    String fecha;
}
