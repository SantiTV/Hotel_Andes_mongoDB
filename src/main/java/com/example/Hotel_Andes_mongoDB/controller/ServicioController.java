package com.example.Hotel_Andes_mongoDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Hotel_Andes_mongoDB.modelo.Servicio;

import repository.ServicioRepository;

import java.util.Date;
import java.util.List;

@RestController
public class ServicioController {

    private final ServicioRepository servicioRepository;

    @Autowired
    public ServicioController(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }

    @GetMapping("/api/servicios")
    public List<Servicio> obtenerServiciosConInformacion(
            @RequestParam int idCliente,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        return servicioRepository.obtenerConsumosConInformacionDeServicio(idCliente, fechaInicio, fechaFin);
    }
}
