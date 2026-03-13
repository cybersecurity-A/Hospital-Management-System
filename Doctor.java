package Hospital_Management_System;
public class Doctor extends Person {
    private String department;
    public Doctor(String id, String name, String cnic, String department) {
        this.id = id;
        this.name = name;
        this.cnic = cnic;
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
