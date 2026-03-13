package Hospital_Management_System;
import java.util.*;

public class DoctorService {
    private List<Doctor> doctors = new ArrayList<>();

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public List<Doctor> getAll() {
        return doctors;
    }
}
