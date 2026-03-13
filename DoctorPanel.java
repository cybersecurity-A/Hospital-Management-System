package Hospital_Management_System;

import java.util.*;
import javax.swing.*;

public class DoctorPanel extends JPanel {

    static DoctorService service = new DoctorService();
    JTextArea area = new JTextArea();
    AppointmentPanel appointmentPanel;

    public DoctorPanel(AppointmentPanel ap) {
        this.appointmentPanel = ap;
        setLayout(null);

        JLabel lblName = new JLabel("Doctor Name:");
        JLabel lblDept = new JLabel("Department:");

        JTextField name = new JTextField();
        JTextField dept = new JTextField();

        JButton add = new JButton("Add Doctor");
        JButton view = new JButton("View Doctors");

        lblName.setBounds(30, 40, 120, 25);
        lblDept.setBounds(30, 80, 120, 25);

        name.setBounds(160, 40, 150, 25);
        dept.setBounds(160, 80, 150, 25);

        add.setBounds(30, 130, 130, 30);
        view.setBounds(180, 130, 130, 30);

        area.setBounds(350, 40, 350, 300);

        add(lblName); add(lblDept);
        add(name); add(dept);
        add(add); add(view);
        add(area);

        add.addActionListener(e -> {
            if(name.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,"Doctor name required");
                return;
            }
            Doctor d = new Doctor(
                    "D"+System.currentTimeMillis(),
                    name.getText(),
                    "N/A",
                    dept.getText()
            );
            service.addDoctor(d);
            appointmentPanel.refreshDoctors();

            JOptionPane.showMessageDialog(this,"Doctor Added");
        });

        view.addActionListener(e -> {
            area.setText("");
            for(Doctor d : service.getAll()) {
                area.append(
                        "Dr. " + d.getName() +
                                " | Dept: " + d.getDepartment() + "\n"
                );
            }
        });
    }
}
