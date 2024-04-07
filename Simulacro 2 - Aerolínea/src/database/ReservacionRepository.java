package database;

import entities.Reservacion;

import java.util.List;

public interface ReservacionRepository {
    Reservacion insert(Reservacion reservacion);

    boolean update(Reservacion reservacion);

    boolean delete(Reservacion reservacion);

    Reservacion findById(int idReservacion);

    List<Reservacion> findAll();
}
