package entities;

public class Airplane {
    private int id;

    private String model;

    private int capacity;

    public Airplane(String model, int capacity) {
        this.model = model;
        this.capacity = capacity;
    }


    public Airplane() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
