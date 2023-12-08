package com.example.Hotel_Andes_mongoDB.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.Hotel_Andes_mongoDB.modelo.Hotel;
import com.example.Hotel_Andes_mongoDB.modelo.Hotel.TipoHabitacion;

public interface HotelRepository extends MongoRepository<Hotel, Integer>{

     // Insertar tipo de habitacion 
    @Query("{" +
            "'id_hotel' : ?0, " +
            "'tipo_habitacion': { " +
            "$push: { " +
            "    'id_tipo_habitacion': ?#{#tipoHabitacion.id_tipo_habitacion}, " +
            "    'nombre': ?#{#tipoHabitacion.nombre}, " +
            "    'dotacion': ?#{#tipoHabitacion.dotacion} " +
            "} " +
            "}")
    void insertarNuevoTipoHabitacion(@Param("idHotel") int idHotel, @Param("tipoHabitacion") TipoHabitacion tipoHabitacion);

     // Actualizar tipo de habitacion 
    @Query("{" +
            "'tipo_habitacion.id_tipo_habitacion' : ?0 " +
            "}")
    void actualizarTipoHabitacion(@Param("idTipoHabitacion") int idTipoHabitacion, @Param("dotacion") String dotacion);


    // Borrar tipo de habitacion 
    @Query("{" +
            "'id_hotel' : ?0, " +
            "'tipo_habitacion.id_tipo_habitacion': ?1 " +
            "}")
    void borrarTipoHabitacion(@Param("idHotel") int idHotel, @Param("idTipoHabitacion") int idTipoHabitacion);

    // Consultar tipos de habitaciones
    @Query("{" +
            "'id_hotel' : ?0 " +
            "}")
    List<Hotel> consultarTiposHabitaciones(@Param("idHotel") int idHotel);

    // Consultar un solo tipo de habitación
    @Query("{" +
            "'id_hotel': ?0, " +
            "'tipo_habitacion.id_tipo_habitacion': ?1 " +
            "}")
    List<Hotel> consultarTipoHabitacion(@Param("idHotel") int idHotel, @Param("idTipoHabitacion") int idTipoHabitacion);

}