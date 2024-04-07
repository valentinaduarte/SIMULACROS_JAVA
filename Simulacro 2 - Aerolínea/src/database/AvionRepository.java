package database;

import entities.Avion;

import java.util.List;

public interface AvionRepository {

    /**
     * Este metodo sirve para insertar aviones
     * @param avion Es el avion que deseamos insertar
     * @return Retorna el avion insertado
     */
    Avion insert(Avion avion);

    /**
     *
     * @param avion
     * @return
     */
    boolean update(Avion avion);

    boolean delete(Avion avion);

    Avion findById(int idAvion);

    List<Avion> findAll();
}
