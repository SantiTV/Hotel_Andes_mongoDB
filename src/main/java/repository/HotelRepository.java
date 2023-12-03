package repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.Hotel_Andes_mongoDB.modelo.Hotel;

public interface HotelRepository extends MongoRepository<Hotel, Integer> {
    // Puedes agregar métodos personalizados según tus necesidades
}
