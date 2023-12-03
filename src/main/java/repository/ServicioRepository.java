package repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.core.aggregation.Aggregation;


import com.example.Hotel_Andes_mongoDB.modelo.Servicio;

public interface ServicioRepository extends MongoRepository<Servicio, String> {
    // Puedes agregar métodos adicionales según tus necesidades
    
    // Agregamos el método de agregación a este repositorio

    @Query("[ { $match: { id_cliente: ?0, fecha_consumo: { $gte: ?1, $lte: ?2 } } }, { $lookup: { from: 'servicio', localField: 'id_servicio', foreignField: 'id_servicio', as: 'servicio_info' } }, { $unwind: '$servicio_info' }, { $project: { _id: 0, id_consumo: '$id_consumo', id_servicio: '$servicio_info.id_servicio', nombre_servicio: '$servicio_info.nombre', descripcion_servicio: '$servicio_info.descripcion', costo_servicio: '$servicio_info.costoadicional', fecha_consumo: '$fecha_consumo', cantidad: '$cantidad' } } ]")
List<Servicio> obtenerConsumosConInformacionDeServicio(int idCliente, java.util.Date fechaInicio, java.util.Date fechaFin);



}




