package entities;

import java.util.Date;

public class Reservacion {
    private int idReservacion;

    private Date fechaReservacion;

    private String asiento;

    private int idVuelo;

    private int idPasajero;

    public Reservacion(int idReservacion, Date fechaReservacion, String asiento, int idVuelo, int idPasajero) {
        this.idReservacion = idReservacion;
        this.fechaReservacion = fechaReservacion;
        this.asiento = asiento;
        this.idVuelo = idVuelo;
        this.idPasajero = idPasajero;
    }

    public int getIdReservacion() {
        return idReservacion;
    }

    public void setIdReservacion(int idReservacion) {
        this.idReservacion = idReservacion;
    }

    public Date getFechaReservacion() {
        return fechaReservacion;
    }

    public void setFechaReservacion(Date fechaReservacion) {
        this.fechaReservacion = fechaReservacion;
    }

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    @Override
    public String toString() {
        return "Reservacion{" +
                "idReservacion=" + idReservacion +
                ", fechaReservacion=" + fechaReservacion +
                ", asiento='" + asiento + '\'' +
                ", idVuelo=" + idVuelo +
                ", idPasajero=" + idPasajero +
                '}';
    }
}
