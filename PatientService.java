package Hospital_Management_System;
import java.util.*;
public class PatientService {
    private List<Patient> patients = new ArrayList<>();

    public boolean addPatient(Patient p) {
        for (Patient x : patients) {
            if (x.getCnic().equals(p.getCnic()))
                return false;
        }
        patients.add(p);
        return true;
    }

    public List<Patient> getAll() {
        return patients;
    }

    public Patient findByCnic(String cnic) {
        for (Patient p : patients) {
            if (p.getCnic().equals(cnic))
                return p;
        }
        return null;
    }
}
