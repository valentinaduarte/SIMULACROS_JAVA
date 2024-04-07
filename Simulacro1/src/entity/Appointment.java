package entity;

public class Appointment {
    private int id;

    private String date;

    private String time;

    private String  motive;

    private int idPatient;

    private int idMedic;

    private Medic objMedic;

    private Patient objPatient;

    public Appointment(String date, String time, String motive, int idPatient, int idMedic, Medic objMedic, Patient objPatient) {
        this.date = date;
        this.time = time;
        this.motive = motive;
        this.idPatient = idPatient;
        this.idMedic = idMedic;
        this.objMedic = objMedic;
        this.objPatient = objPatient;
    }

    public Appointment(){

    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }

    public int getIdMedic() {
        return idMedic;
    }

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public Medic getObjMedic() {
        return objMedic;
    }

    public void setObjMedic(Medic objMedic) {
        this.objMedic = objMedic;
    }

    public Patient getObjPatient() {
        return objPatient;
    }

    public void setObjPatient(Patient objPatient) {
        this.objPatient = objPatient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", motive='" + motive + '\'' +
                ", idPatient=" + idPatient +
                ", idMedic=" + idMedic +
                ", objMedic=" + objMedic.getName() +
                ", objPatient=" + objPatient.getName() +
                '}';
    }
}
