package Hospital_Management_System;
import java.util.*;
public class AppointmentService {
    private List<Appointment> list = new ArrayList<>();

    public void add(Appointment a) {
        list.add(a);
    }

    public List<Appointment> getAll() {
        return list;
    }
}
