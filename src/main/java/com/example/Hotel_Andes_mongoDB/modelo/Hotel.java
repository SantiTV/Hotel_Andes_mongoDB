package com.example.Hotel_Andes_mongoDB.modelo;

public class Hotel {

    private int idHotel;
    private String nombre;
    private String cadenaHotelera;
    private String direccion;
    private String categoria;

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
}
