package Hospital_Management_System;

import javax.swing.*;

public class PatientPanel extends JPanel {

    static PatientService service = new PatientService();
    JTextArea area = new JTextArea();

    // Reference to DiseasePanel (set via setter)
    private DiseasePanel diseasePanelRef;

    public PatientPanel() {   // constructor untouched
        setLayout(null);

        JLabel lblName = new JLabel("Name:");
        JLabel lblCnic = new JLabel("CNIC:");
        JLabel lblAge = new JLabel("Age:");
        JLabel lblGender = new JLabel("Gender:");

        JTextField name = new JTextField();
        JTextField cnic = new JTextField();
        JTextField age = new JTextField();
        JTextField gender = new JTextField();

        JButton add = new JButton("Add Patient");
        JButton view = new JButton("View Patients");

        lblName.setBounds(30, 30, 80, 25);
        lblCnic.setBounds(30, 70, 80, 25);
        lblAge.setBounds(30, 110, 80, 25);
        lblGender.setBounds(30, 150, 80, 25);

        name.setBounds(110, 30, 150, 25);
        cnic.setBounds(110, 70, 150, 25);
        age.setBounds(110, 110, 150, 25);
        gender.setBounds(110, 150, 150, 25);

        add.setBounds(30, 200, 110, 30);
        view.setBounds(150, 200, 110, 30);

        area.setBounds(300, 30, 350, 300);

        add(lblName); add(lblCnic); add(lblAge); add(lblGender);
        add(name); add(cnic); add(age); add(gender);
        add(add); add(view); add(area);

        // Add patient
        add.addActionListener(e -> {
            if(name.getText().isEmpty() || cnic.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,"Name & CNIC required");
                return;
            }

            try {
                Patient p = new Patient(
                        "P"+System.currentTimeMillis(),
                        name.getText(),
                        cnic.getText(),
                        Integer.parseInt(age.getText()),
                        gender.getText()
                );

                if(service.addPatient(p)) {
                    JOptionPane.showMessageDialog(this,"Patient Added");

            
                    if(diseasePanelRef != null)
                        diseasePanelRef.refreshPatients();

                } else {
                    JOptionPane.showMessageDialog(this,"CNIC already exists");
                }

            } catch(NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"Age must be a number");
            }
        });

        // View patients
        view.addActionListener(e -> {
            area.setText("");
            for(Patient p : service.getAll()) {
                area.append(
                        "Name: " + p.getName() +
                                " | CNIC: " + p.getCnic() +
                                " | Age: " + p.getAge() +
                                " | Gender: " + p.getGender() + "\n"
                );
            }
        });
    }

    public void setDiseasePanel(DiseasePanel disPanel) {
        this.diseasePanelRef = disPanel;
    }
}

