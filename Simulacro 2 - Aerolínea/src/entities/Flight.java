package entities;

import java.sql.Time;
import java.util.Date;

public class Flight {
    private int id;

    private String destination;

    private String departureDate;

    private String departureTime;

    private int idAvion;

    private Airplane ObjAirplane;

    public Flight(String destination, String departureDate, String departureTime, int idAvion,Airplane objAirplane) {
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.idAvion = idAvion;
        ObjAirplane = objAirplane;
    }

    public Airplane getObjAirplane() {
        return ObjAirplane;
    }

    public void setObjAirplane(Airplane objAirplane) {
        ObjAirplane = objAirplane;
    }

    public Flight() {};

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }


    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", destination='" + destination + '\'' +
                ", departureDate='" + departureDate + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", idAvion=" + idAvion +
                ", ObjAirplane=" + ObjAirplane +
                '}';
    }
}
