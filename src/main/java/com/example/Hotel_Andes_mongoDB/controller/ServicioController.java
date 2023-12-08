package com.example.Hotel_Andes_mongoDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Hotel_Andes_mongoDB.modelo.Servicio;

import repository.ServicioRepository;

import java.util.List;

@RestController
@RequestMapping("/api/servicio")
public class ServicioController {

    @Autowired
    private ServicioRepository servicioRepository;

    // Endpoint to insert a new servicio
    @PostMapping("/insertarServicio")
    public void insertarServicio(@RequestBody Servicio servicio) {
        servicioRepository.insertarServicio(servicio);
    }

    // Endpoint to update a servicio
    @PutMapping("/actualizarServicio/{idServicio}")
    public void actualizarServicio(@PathVariable int idServicio, @RequestBody Servicio servicio) {
        servicioRepository.actualizarServicio(idServicio, servicio.getCostoAdicional(), servicio.getHorario());
    }

    // Endpoint to delete a servicio
    @DeleteMapping("/borrarServicio/{idServicio}")
    public void borrarServicio(@PathVariable int idServicio) {
        servicioRepository.borrarServicio(idServicio);
    }

    // Endpoint to get all servicios
    @GetMapping("/consultarServicios")
    public List<Servicio> consultarServicios() {
        return servicioRepository.consultarServicios();
    }

    // Endpoint to get a single servicio by ID
    @GetMapping("/consultarServicio/{idServicio}")
    public Servicio consultarServicioPorId(@PathVariable int idServicio) {
        return servicioRepository.consultarServicioPorId(idServicio);
    }
}