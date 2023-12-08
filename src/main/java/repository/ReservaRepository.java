package repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;

import com.example.Hotel_Andes_mongoDB.modelo.Reserva;

import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface ReservaRepository extends MongoRepository<Reserva, Integer> {

    // Insertar una reserva
    @Query("{'id_reserva' : ?#{#reserva.id_reserva}}")
    void insertarReserva(@Param("reserva") Reserva reserva);

    // Actualizar una reserva
    @Query("{'id_reserva' : ?#{#reserva.id_reserva}}")
    void actualizarReserva(@Param("reserva") Reserva reserva);

    // Borrar una reserva
    @Query("{'id_reserva' : ?0}")
    void borrarReserva(@Param("idReserva") int idReserva);

    // Consultar todas las reservas
    @Query("{}")
    List<Reserva> consultarTodasLasReservas();

    // Consultar una reserva por su ID
    @Query("{'id_reserva' : ?0}")
    Reserva consultarReservaPorId(@Param("idReserva") int idReserva);

    //obtener el índice de ocupación de cada habitación en el último año corrido
    @Query(value = "{ " +
            "$match: { 'fechaentrada': { $gte: ?0 } }, " +
            "$group: { _id: '$id_habitacion', totalReservas: { $sum: 1 } }, " +
            "$lookup: { " +
            "    from: 'habitacion', " +
            "    localField: '_id', " +
            "    foreignField: 'id_habitacion', " +
            "    as: 'habitacion_info' " +
            "}, " +
            "$unwind: '$habitacion_info', " +
            "$project: { " +
            "    _id: 0, " +
            "    id_habitacion: '$_id', " +
            "    nombre_habitacion: '$habitacion_info.nombre', " +
            "    indiceOcupacion: { $divide: ['$totalReservas', '$habitacion_info.capacidad'] } " +
            "} " +
            "}")
    List<Reserva> obtenerIndiceOcupacionEnUltimoAnio(@Param("fechaInicio") Date fechaInicio);

    // obtener la información de los clientes excelentes
    @Query(value = "{ " +
            "$lookup: { " +
            "    from: 'clientes', " +
            "    localField: 'id_cliente', " +
            "    foreignField: 'id_clientes', " +
            "    as: 'cliente_info' " +
            "}, " +
            "$unwind: '$cliente_info', " +
            "$project: { " +
            "    _id: 0, " +
            "    id_cliente: '$cliente_info.id_clientes', " +
            "    nombre_cliente: '$cliente_info.nombre', " +
            "    fecha_entrada: '$fechaentrada', " +
            "    fecha_salida: '$fechasalida', " +
            "    trimestre: { " +
            "        $let: { " +
            "            vars: { " +
            "                trimestres: [ " +
            "                    { $in: [{ $month: '$fechaentrada' }, [1, 2, 3]] }, " +
            "                    { $in: [{ $month: '$fechaentrada' }, [4, 5, 6]] }, " +
            "                    { $in: [{ $month: '$fechaentrada' }, [7, 8, 9]] }, " +
            "                    { $in: [{ $month: '$fechaentrada' }, [10, 11, 12]] } " +
            "                ] " +
            "            }, " +
            "            in: { " +
            "                $cond: { " +
            "                    if: { " +
            "                        $or: [ " +
            "                            { $and: ['$$trimestres.0', '$$trimestres.1', '$$trimestres.2'] }, " +
            "                            { $and: ['$$trimestres.1', '$$trimestres.2', '$$trimestres.3'] } " +
            "                        ] " +
            "                    }, " +
            "                    then: 'Excelente', " +
            "                    else: 'No Excelente' " +
            "                } " +
            "            } " +
            "        } " +
            "    } " +
            "}, " +
            "$match: { " +
            "    trimestre: 'Excelente' " +
            "}" +
            "}")
    List<Reserva> obtenerClientesExcelentes();

}