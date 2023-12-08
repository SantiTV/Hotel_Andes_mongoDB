package com.example.Hotel_Andes_mongoDB.modelo;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.ToString;

@Document(collection="clientes")
@ToString
public class Hotel {
    @Id
    private int idHotel;
    private String nombre;
    private String cadenaHotelera;
    private String direccion;
    private String categoria;
    private List<TipoHabitacion> tipo_habitacion;

    public Hotel(int idHotel, String nombre, String cadenaHotelera, String direccion, String categoria) {
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.cadenaHotelera = cadenaHotelera;
        this.direccion = direccion;
        this.categoria = categoria;
    }

    public int getIdHotel() {
        return idHotel;
    }

    public void setIdHotel(int idHotel) {
        this.idHotel = idHotel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCadenaHotelera() {
        return cadenaHotelera;
    }

    public void setCadenaHotelera(String cadenaHotelera) {
        this.cadenaHotelera = cadenaHotelera;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public List<TipoHabitacion> getTipo_habitacion() {
        return tipo_habitacion;
    }
    public void setOferta_bebidas(List<TipoHabitacion> tipo_habitacion) {
        this.tipo_habitacion = tipo_habitacion;
    }

    public class TipoHabitacion {

        private int id_tipo_habitacion;
        private String nombre;
        private String dotacion;

    public TipoHabitacion(int id_tipo_habitacion, String nombre, String dotacion) {
        this.id_tipo_habitacion = id_tipo_habitacion;
        this.nombre = nombre;
        this.dotacion = dotacion;
    }

    public int getIdTipoHabitacion() {
        return id_tipo_habitacion;
    }

    public void setIdTipoHabitacion(int id_tipo_habitacion) {
        this.id_tipo_habitacion = id_tipo_habitacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDotacion() {
        return dotacion;
    }

    public void setDotacion(String dotacion) {
        this.dotacion = dotacion;
    }
  
 }
}