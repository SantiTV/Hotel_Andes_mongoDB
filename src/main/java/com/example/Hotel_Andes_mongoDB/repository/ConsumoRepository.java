package com.example.Hotel_Andes_mongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.example.Hotel_Andes_mongoDB.modelo.Consumo;

import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ConsumoRepository extends MongoRepository<Consumo, Integer> {

    // Insertar un consumo
    @Query("{'id_consumo' : ?#{#consumo.id_consumo}}")
    void insertarConsumo(@Param("consumo") Consumo consumo);

    // Actualizar un consumo
    @Query("{'id_consumo' : ?#{#consumo.id_consumo}}")
    void actualizarConsumo(@Param("consumo") Consumo consumo);

    // Borrar un consumo
    @Query("{'id_consumo' : ?0}")
    void borrarConsumo(@Param("idConsumo") int idConsumo);

    // Consultar todos los consumos
    @Query("{}")
    List<Consumo> consultarTodosLosConsumos();

    // Consultar un consumo por su ID
    @Query("{'id_consumo' : ?0}")
    Consumo consultarConsumoPorId(@Param("idConsumo") int idConsumo);
}