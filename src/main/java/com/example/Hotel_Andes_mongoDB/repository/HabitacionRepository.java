package com.example.Hotel_Andes_mongoDB.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Hotel_Andes_mongoDB.modelo.Habitacion;

public interface HabitacionRepository extends MongoRepository<Habitacion, Integer> {

    // Insertar habitación
    @Query("{ 'id_habitacion': ?#{#habitacion.id_habitacion}, 'tipo': ?#{#habitacion.tipo}, 'capacidad': ?#{#habitacion.capacidad}, 'costo': ?#{#habitacion.costo}, 'cuenta': ?#{#habitacion.cuenta} }")
    void insertarHabitacion(@Param("habitacion") Habitacion habitacion);

    // Actualizar habitación
    @Query("{" +
            "'id_habitacion' : ?0 " +
            "}")
    void actualizarHabitacion(@Param("idHabitacion") int idHabitacion, @Param("costo") double costo);

    // Borrar habitación
    @Query("{" +
            "'id_habitacion' : ?0 " +
            "}")
    void borrarHabitacion(@Param("idHabitacion") int idHabitacion);

    // Consultar habitación: Obtener todas las habitaciones
    @Query("{}")
    List<Habitacion> consultarHabitaciones();

    // Consultar habitación: Obtener una habitación específica por su ID
    @Query("{" +
            "'id_habitacion' : ?0 " +
            "}")
    Habitacion consultarHabitacionPorId(@Param("idHabitacion") int idHabitacion);

    // Obtener el dinero recolectado por servicios en cada habitación en el último año corrido 
    @Query(value = "{ " +
            "$match: { 'tipo_habitacion.id_tipo_habitacion': ?0 }, " +
            "$lookup: { " +
            "    from: 'consumo', " +
            "    localField: 'id_habitacion', " +
            "    foreignField: 'id_habitacion', " +
            "    as: 'consumos' " +
            "}, " +
            "$unwind: '$consumo', " +
            "$match: { 'consumo.fecha_consumo': { $gte: ?1 } }, " +
            "$group: { " +
            "    _id: '$id_habitacion', " +
            "    habitacion: { $first: '$$ROOT' }, " +
            "    totalRecaudado: { $sum: { $multiply: ['$consumo.cantidad', '$consumo.habitacion_info.costo'] } } " +
            "}, " +
            "$project: { " +
            "    _id: 0, " +
            "    habitacion: 1, " +
            "    totalRecaudado: 1 " +
            "} " +
            "}")

    List<Habitacion> obtenerDineroRecolectadoPorHabitacionEnUltimoAnio(
            @Param("idTipoHabitacion") int idTipoHabitacion,
            @Param("fechaInicio") Date fechaInicio
    );

}