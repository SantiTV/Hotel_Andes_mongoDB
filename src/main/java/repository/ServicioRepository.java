package repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.Hotel_Andes_mongoDB.modelo.Servicio;


public interface ServicioRepository extends MongoRepository<Servicio, Integer> {

    // Insertar un servicio
    @Query("{ 'id_servicio': ?#{#servicio.id_servicio}, 'nombre': ?#{#servicio.nombre}, 'descripcion': ?#{#servicio.descripcion}, 'costoadicional': ?#{#servicio.costoadicional}, 'horario': ?#{#servicio.horario}, 'disponibilidad': ?#{#servicio.disponibilidad} }")
    void insertarServicio(@Param("servicio") Servicio servicio);

    // Actualizar un servicio
    @Query("{" +
            "'id_servicio' : ?0 " +
            "}")
    void actualizarServicio(@Param("idServicio") int idServicio, @Param("costoAdicional") double costoAdicional, @Param("horario") int i);

    // Borrar un servicio
    @Query("{" +
            "'id_servicio' : ?0 " +
            "}")
    void borrarServicio(@Param("idServicio") int idServicio);

    // Consultar servicios: Obtener todos los servicios
    @Query("{}")
    List<Servicio> consultarServicios();

    // Consultar servicios: Obtener un servicio específico por su ID
    @Query("{" +
            "'id_servicio' : ?0 " +
            "}")
    Servicio consultarServicioPorId(@Param("idServicio") int idServicio);
}


