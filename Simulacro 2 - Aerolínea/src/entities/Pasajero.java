package entities;

public class Pasajero {
    private int idPasajero;

    private String nombre;

    private String apellido;

    private String documentoIdentidad;

    public Pasajero(int idPasajero, String nombre, String apellido, String documentoIdentidad) {
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documentoIdentidad = documentoIdentidad;
    }

    public Pasajero() {

    }

    public int getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(int idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "idPasajero=" + idPasajero +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", documentoIdentidad='" + documentoIdentidad + '\'' +
                '}';
    }
}
