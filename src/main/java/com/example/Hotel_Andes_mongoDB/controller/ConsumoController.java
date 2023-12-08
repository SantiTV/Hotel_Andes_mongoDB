package com.example.Hotel_Andes_mongoDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Hotel_Andes_mongoDB.modelo.Consumo;
import com.example.Hotel_Andes_mongoDB.repository.ConsumoRepository;

import java.util.List;

@RestController
@RequestMapping("/api/consumo")
public class ConsumoController {

    @Autowired
    private ConsumoRepository consumoRepository;

    // Insertar un consumo
    @PostMapping("/insertarConsumo")
    public void insertarConsumo(@RequestBody Consumo consumo) {
        consumoRepository.insertarConsumo(consumo);
    }

    // Actualizar un consumo
    @PutMapping("/actualizarConsumo")
    public void actualizarConsumo(@RequestBody Consumo consumo) {
        consumoRepository.actualizarConsumo(consumo);
    }

    // Borrar un consumo
    @DeleteMapping("/borrarConsumo/{idConsumo}")
    public void borrarConsumo(@PathVariable int idConsumo) {
        consumoRepository.borrarConsumo(idConsumo);
    }

    // Consultar todos los consumos
    @GetMapping("/consultarTodosLosConsumos")
    public List<Consumo> consultarTodosLosConsumos() {
        return consumoRepository.consultarTodosLosConsumos();
    }

    // Consultar un consumo por su ID
    @GetMapping("/consultarConsumoPorId/{idConsumo}")
    public Consumo consultarConsumoPorId(@PathVariable int idConsumo) {
        return consumoRepository.consultarConsumoPorId(idConsumo);
    }
}
