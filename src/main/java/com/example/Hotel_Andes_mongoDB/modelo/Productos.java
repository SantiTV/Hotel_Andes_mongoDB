package com.example.Hotel_Andes_mongoDB.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="productos")
@ToString
public class Productos {

    private int idProductos;
    private String nombre;
    private int costo;

    public Productos(int idProductos, String nombre, int costo) {
        this.idProductos = idProductos;
        this.nombre = nombre;
        this.costo = costo;
    }

    public int getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(int idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}

