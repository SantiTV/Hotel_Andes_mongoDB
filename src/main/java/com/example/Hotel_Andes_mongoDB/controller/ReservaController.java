package com.example.Hotel_Andes_mongoDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import com.example.Hotel_Andes_mongoDB.modelo.Reserva;
import com.example.Hotel_Andes_mongoDB.repository.ReservaRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/reserva")
public class ReservaController {

    @Autowired
    private ReservaRepository reservaRepository;

    @PostMapping("/insertarReserva")
    public void insertarReserva(@RequestBody Reserva reserva) {
        reservaRepository.insertarReserva(reserva);
    }

    @PutMapping("/actualizarReserva/{idReserva}")
    public void actualizarReserva(@PathVariable int idReserva, @RequestBody Reserva reserva) {
        reservaRepository.actualizarReserva(reserva);
    }

    @DeleteMapping("/borrarReserva/{idReserva}")
    public void borrarReserva(@PathVariable int idReserva) {
        reservaRepository.borrarReserva(idReserva);
    }

    @GetMapping("/consultarReservas")
    public List<Reserva> consultarTodasLasReservas() {
        return reservaRepository.consultarTodasLasReservas();
    }

    @GetMapping("/consultarReserva/{idReserva}")
    public Reserva consultarReservaPorId(@PathVariable int idReserva) {
        return reservaRepository.consultarReservaPorId(idReserva);
    }

    @GetMapping("/indiceOcupacion")
    public List<Reserva> obtenerIndiceOcupacionEnUltimoAnio(
            @RequestParam("fechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio) {
        return reservaRepository.obtenerIndiceOcupacionEnUltimoAnio(fechaInicio);
    }

    @GetMapping("/clientesExcelentes")
    public List<Reserva> obtenerClientesExcelentes() {
        return reservaRepository.obtenerClientesExcelentes();
    }
}