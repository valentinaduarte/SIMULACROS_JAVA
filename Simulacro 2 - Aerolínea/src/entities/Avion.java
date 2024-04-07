package entities;

public class Avion {
    private int idAvion;

    private String modelo;

    private int capacidad;

    public Avion(int idAvion, String modelo, int capacidad) {
        this.idAvion = idAvion;
        this.modelo = modelo;
        this.capacidad = capacidad;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id_avion=" + idAvion +
                ", modelo='" + modelo + '\'' +
                ", capacidad=" + capacidad +
                '}';
    }
}
