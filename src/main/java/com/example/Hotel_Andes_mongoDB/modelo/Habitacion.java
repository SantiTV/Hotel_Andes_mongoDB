

package com.example.Hotel_Andes_mongoDB.modelo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="habitacion")
@ToString
public class Habitacion {
    @Id
    private int idHabitacion;
    private String tipo;
    private int capacidad;
    private int dotacion;
    private int costo;
    private int cuenta;
    private int idReserva;

    public Habitacion(int idHabitacion, String tipo, int capacidad, int dotacion, int costo, int cuenta, int idReserva) {
        this.idHabitacion = idHabitacion;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.dotacion = dotacion;
        this.costo = costo;
        this.cuenta = cuenta;
        this.idReserva = idReserva;
    }

    public int getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(int idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getDotacion() {
        return dotacion;
    }

    public void setDotacion(int dotacion) {
        this.dotacion = dotacion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCuenta() {
        return cuenta;
    }

    public void setCuenta(int cuenta) {
        this.cuenta = cuenta;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }
}
