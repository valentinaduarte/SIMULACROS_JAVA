package entities;

import java.sql.Time;
import java.util.Date;

public class Vuelo {
    private int idVuelo;

    private String destino;

    private Date fechaSalida;

    private Time horaSalida;

    private int idAvion;

    public Vuelo(int idVuelo, String destino, Date fechaSalida, Time horaSalida, int idAvion) {
        this.idVuelo = idVuelo;
        this.destino = destino;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.idAvion = idAvion;
    }


    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }


    @Override
    public String toString() {
        return "Vuelo{" +
                "idVuelo=" + idVuelo +
                ", destino='" + destino + '\'' +
                ", fechaSalida=" + fechaSalida +
                ", horaSalida=" + horaSalida +
                ", idAvion=" + idAvion +
                '}';
    }
}
