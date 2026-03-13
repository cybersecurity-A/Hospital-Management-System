package Hospital_Management_System;
public class Patient extends Person {
    private int age;
    private String gender;

    public Patient(String id, String name, String cnic, int age, String gender) {
        this.id = id;
        this.name = name;
        this.cnic = cnic;
        this.age = age;
        this.gender = gender;
    }

    public int getAge() { return age; }
    public String getGender() { return gender; }
}
