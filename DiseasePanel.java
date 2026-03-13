package Hospital_Management_System;

import javax.swing.*;

public class DiseasePanel extends JPanel {

    DiseaseService service = new DiseaseService();
    JTextArea area = new JTextArea();
    JComboBox<String> patientBox = new JComboBox<>();

    public DiseasePanel() {
        setLayout(null);

        JLabel lblPatient = new JLabel("Select Patient:");
        JLabel lblDisease = new JLabel("Disease:");

        JTextField disease = new JTextField();
        JButton add = new JButton("Add Record");
        JButton view = new JButton("View Records");

        lblPatient.setBounds(30,30,120,25);
        lblDisease.setBounds(30,70,120,25);
        patientBox.setBounds(160,30,180,25);
        disease.setBounds(160,70,180,25);
        add.setBounds(30,120,140,30);
        view.setBounds(200,120,140,30);
        area.setBounds(380,30,350,300);

        add(lblPatient); add(patientBox);
        add(lblDisease); add(disease);
        add(add); add(view); add(area);

        // Add disease
        add.addActionListener(e -> {
            if(disease.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,"Enter disease");
                return;
            }
            Disease d = new Disease(
                    patientBox.getSelectedItem().toString(),
                    disease.getText()
            );
            service.addRecord(d);
            JOptionPane.showMessageDialog(this,"Disease Record Added");
        });

        // View disease
        view.addActionListener(e -> {
            area.setText("");
            String cnic = patientBox.getSelectedItem().toString();
            for(Disease d : service.getByPatient(cnic)) {
                area.append("Disease: " + d.getDisease() + "\n");
            }
        });

        // Initial populate
        refreshPatients();
    }

Refresh dropdown whenever patient list changes
    public void refreshPatients() {
        patientBox.removeAllItems();
        for(Patient p : PatientPanel.service.getAll()) {
            patientBox.addItem(p.getCnic());
        }
    }
}

