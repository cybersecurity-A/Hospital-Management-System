package Hospital_Management_System;
public class Disease {
    private String patientCnic;
    private String disease;
    public Disease(String patientCnic, String disease) {
        this.patientCnic = patientCnic;
        this.disease = disease;
    }
    public String getPatientCnic() {
        return patientCnic;
    }
    public String getDisease() {
        return disease;
    }
}
