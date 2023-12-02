package com.example.Hotel_Andes_mongoDB.modelo;

import java.util.Date;

public class Consumo {

    private String registros;
    private Date fecha;

    public Consumo(String registros, Date fecha) {
        this.registros = registros;
        this.fecha = fecha;
    }

    public String getRegistros() {
        return registros;
    }

    public void setRegistros(String registros) {
        this.registros = registros;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
