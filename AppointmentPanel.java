package Hospital_Management_System;

import java.util.*;
import javax.swing.*;

public class AppointmentPanel extends JPanel {

    AppointmentService service = new AppointmentService();
    JTextArea area = new JTextArea();
    JComboBox<String> doctorBox = new JComboBox<>();

    public AppointmentPanel() {
        setLayout(null);

        JLabel lblCnic = new JLabel("Patient CNIC:");
        JLabel lblDate = new JLabel("Date:");
        JLabel lblDoctor = new JLabel("Doctor:");

        JTextField cnic = new JTextField();
        JTextField date = new JTextField();

        JButton book = new JButton("Book Appointment");
        JButton view = new JButton("View Appointments");

        refreshDoctors();   // 🔥 important fix

        lblCnic.setBounds(30, 40, 120, 25);
        lblDate.setBounds(30, 80, 120, 25);
        lblDoctor.setBounds(30, 120, 120, 25);

        cnic.setBounds(160, 40, 150, 25);
        date.setBounds(160, 80, 150, 25);
        doctorBox.setBounds(160, 120, 150, 25);

        book.setBounds(30, 170, 160, 30);
        view.setBounds(200, 170, 160, 30);

        area.setBounds(350, 40, 350, 300);

        add(lblCnic); add(lblDate); add(lblDoctor);
        add(cnic); add(date); add(doctorBox);
        add(book); add(view);
        add(area);

        book.addActionListener(e -> {
            Patient p = PatientPanel.service.findByCnic(cnic.getText());
            if(p == null) {
                JOptionPane.showMessageDialog(this,"Patient not found");
                return;
            }

            if(doctorBox.getSelectedIndex() == -1) {
                JOptionPane.showMessageDialog(this,"No doctor available");
                return;
            }

            Doctor d = DoctorPanel.service.getAll()
                    .get(doctorBox.getSelectedIndex());

            Appointment a = new Appointment(p, d, date.getText());
            service.add(a);

            JOptionPane.showMessageDialog(this,"Appointment Booked");
        });

        view.addActionListener(e -> {
            area.setText("");
            for(Appointment a : service.getAll()) {
                area.append(a.toString() + "\n");
            }
        });
    }

    // 🔥 AUTO REFRESH METHOD
    public void refreshDoctors() {
        doctorBox.removeAllItems();
        for(Doctor d : DoctorPanel.service.getAll()) {
            doctorBox.addItem(d.getName());
        }
    }
}
