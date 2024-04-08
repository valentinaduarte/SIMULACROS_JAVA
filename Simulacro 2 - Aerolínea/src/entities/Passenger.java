package entities;

public class Passenger {
    private int id;

    private String name;

    private String lastName;

    private String document;


    public Passenger() {
    }

    public Passenger(String name, String lastName, String document) {
        this.name = name;
        this.lastName = lastName;
        this.document = document;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", document='" + document + '\'' +
                '}';
    }
}
