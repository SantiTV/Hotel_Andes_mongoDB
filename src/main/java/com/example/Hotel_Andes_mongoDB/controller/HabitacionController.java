package com.example.Hotel_Andes_mongoDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Hotel_Andes_mongoDB.modelo.Habitacion;
import repository.HabitacionRepository;

import java.util.List;

@RestController
@RequestMapping("/api/habitacion")
public class HabitacionController {

    @Autowired
    private HabitacionRepository habitacionRepository;

    // Endpoint to insert a new habitacion
    @PostMapping("/insertarHabitacion")
    public void insertarHabitacion(@RequestBody Habitacion habitacion) {
        habitacionRepository.insertarHabitacion(habitacion);
    }

    // Endpoint to update a habitacion
    @PutMapping("/actualizarHabitacion/{idHabitacion}")
    public void actualizarHabitacion(@PathVariable int idHabitacion, @RequestBody double costo) {
        habitacionRepository.actualizarHabitacion(idHabitacion, costo);
    }

    // Endpoint to delete a habitacion
    @DeleteMapping("/borrarHabitacion/{idHabitacion}")
    public void borrarHabitacion(@PathVariable int idHabitacion) {
        habitacionRepository.borrarHabitacion(idHabitacion);
    }

    // Endpoint to get all habitaciones
    @GetMapping("/consultarHabitaciones")
    public List<Habitacion> consultarHabitaciones() {
        return habitacionRepository.consultarHabitaciones();
    }

    // Endpoint to get a single habitacion by ID
    @GetMapping("/consultarHabitacion/{idHabitacion}")
    public Habitacion consultarHabitacionPorId(@PathVariable int idHabitacion) {
        return habitacionRepository.consultarHabitacionPorId(idHabitacion);
    }
}