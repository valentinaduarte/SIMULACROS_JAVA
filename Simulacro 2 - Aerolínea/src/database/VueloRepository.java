package database;

import entities.Vuelo;

import java.util.List;

public interface VueloRepository {
    Vuelo insert(Vuelo vuelo);

    boolean update(Vuelo vuelo);

    boolean delete(Vuelo vuelo);

    Vuelo findById(int idVuelo);

    List<Vuelo> findAll();
}
