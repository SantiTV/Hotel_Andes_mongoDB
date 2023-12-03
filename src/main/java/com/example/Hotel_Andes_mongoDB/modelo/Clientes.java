package com.example.Hotel_Andes_mongoDB.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="clientes")
@ToString
public class Clientes {

    private int id;
    private String nombre;
    private String reservas;
    private int consumos;
    private String tipoPlan;

    public Clientes(int id, String nombre, String reservas, int consumos, String tipoPlan) {
        this.id = id;
        this.nombre = nombre;
        this.reservas = reservas;
        this.consumos = consumos;
        this.tipoPlan = tipoPlan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReservas() {
        return reservas;
    }

    public void setReservas(String reservas) {
        this.reservas = reservas;
    }

    public int getConsumos() {
        return consumos;
    }

    public void setConsumos(int consumos) {
        this.consumos = consumos;
    }

    public String getTipoPlan() {
        return tipoPlan;
    }

    public void setTipoPlan(String tipoPlan) {
        this.tipoPlan = tipoPlan;
    }
}
