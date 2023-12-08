package com.example.Hotel_Andes_mongoDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Hotel_Andes_mongoDB.modelo.Hotel;
import com.example.Hotel_Andes_mongoDB.repository.HotelRepository;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {

    @Autowired
    private HotelRepository hotelRepository;

    // Endpoint to insert a new tipo de habitacion
    @PostMapping("/insertarTipoHabitacion")
    public void insertarNuevoTipoHabitacion(@RequestBody Hotel hotel) {
        hotelRepository.insertarNuevoTipoHabitacion(hotel.getIdHotel(), hotel.getTipo_habitacion().get(0));
    }

    // Endpoint to update a tipo de habitacion
    @PutMapping("/actualizarTipoHabitacion/{idTipoHabitacion}")
    public void actualizarTipoHabitacion(@PathVariable int idTipoHabitacion, @RequestBody String dotacion) {
        hotelRepository.actualizarTipoHabitacion(idTipoHabitacion, dotacion);
    }

    // Endpoint to delete a tipo de habitacion
    @DeleteMapping("/borrarTipoHabitacion/{idHotel}/{idTipoHabitacion}")
    public void borrarTipoHabitacion(@PathVariable int idHotel, @PathVariable int idTipoHabitacion) {
        hotelRepository.borrarTipoHabitacion(idHotel, idTipoHabitacion);
    }

    // Endpoint to get all tipos de habitaciones for a hotel
    @GetMapping("/consultarTiposHabitaciones/{idHotel}")
    public List<Hotel> consultarTiposHabitaciones(@PathVariable int idHotel) {
        return hotelRepository.consultarTiposHabitaciones(idHotel);
    }

    // Endpoint to get a single tipo de habitacion for a hotel
    @GetMapping("/consultarTipoHabitacion/{idHotel}/{idTipoHabitacion}")
    public List<Hotel> consultarTipoHabitacion(@PathVariable int idHotel, @PathVariable int idTipoHabitacion) {
        return hotelRepository.consultarTipoHabitacion(idHotel, idTipoHabitacion);
    }
    
}
