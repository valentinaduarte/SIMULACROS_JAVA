package entities;

import java.util.Date;

public class Reservation {
    private static int id;

    private static String reservationDate;

    private static String seat;

    private static int idVuelo;

    private static int idPasajero;

    private static Flight objFlight;

    private static Passenger objPassenger;

    public Reservation() {
    }

    public Reservation( String reservationDate, String seat, int idVuelo, int idPasajero, Flight objFlight, Passenger objPassenger ) {
        this.reservationDate = reservationDate;
        this.seat = seat;
        this.idVuelo = idVuelo;
        this.idPasajero = idPasajero;
        this.objFlight = objFlight;
        this.objPassenger = objPassenger;

    }


    public Flight getObjFlight() {
        return objFlight;
    }

    public void setObjFlight(Flight objFlight) {
        this.objFlight = objFlight;
    }

    public Passenger getObjPassenger() {
        return objPassenger;
    }

    public void setObjPassenger(Passenger objPassenger) {
        this.objPassenger = objPassenger;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public String getSeat() {
        return seat;
    }

    public void setSeat(String seat) {
        this.seat = seat;
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


    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", reservationDate='" + reservationDate + '\'' +
                ", seat='" + seat + '\'' +
                ", idVuelo=" + idVuelo +
                ", idPasajero=" + idPasajero +
                ", objFlight=" + objFlight +
                ", objPassenger=" + objPassenger +
                '}';
    }
}
