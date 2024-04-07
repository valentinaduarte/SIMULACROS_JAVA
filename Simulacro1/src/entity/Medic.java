package entity;

public class Medic {
    private int id;

    private String name;

    private String lastName;

    private int idSpeciality;

    private Speciality objSpeciality;

    public Medic(){
    }

    public Medic( String name, String lastName, int idSpeciality,Speciality objSpeciality) {
        this.name = name;
        this.lastName = lastName;
        this.idSpeciality = idSpeciality;
        this.objSpeciality = objSpeciality;
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

    public int getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(int idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public Speciality getObjSpeciality() {
        return objSpeciality;
    }

    public void setObjSpeciality(Speciality objSpeciality) {
        this.objSpeciality = objSpeciality;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", idSpeciality=" + idSpeciality +
                ", objSpeciality=" + objSpeciality +
                '}';
    }
}
