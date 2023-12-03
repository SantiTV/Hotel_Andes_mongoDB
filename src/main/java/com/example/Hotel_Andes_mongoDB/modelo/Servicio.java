package com.example.Hotel_Andes_mongoDB.modelo;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="servicio")
@ToString
public class Servicio {

    private String nombre;
    private String descripcion;
    private int costoAdicional;
    private int horario;
    private int disponibilidad;

    public Servicio(String nombre, String descripcion, int costoAdicional, int horario, int disponibilidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costoAdicional = costoAdicional;
        this.horario = horario;
        this.disponibilidad = disponibilidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCostoAdicional() {
        return costoAdicional;
    }

    public void setCostoAdicional(int costoAdicional) {
        this.costoAdicional = costoAdicional;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public int getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(int disponibilidad) {
        this.disponibilidad = disponibilidad;
    }
}
