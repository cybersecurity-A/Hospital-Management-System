package Hospital_Management_System;

import javax.swing.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    CardLayout layout = new CardLayout();
    JPanel mainPanel = new JPanel(layout);

    public DashboardFrame() {
        setTitle("Hospital Management System");
        setSize(800,500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Menu Buttons
        JPanel menu = new JPanel(new GridLayout(4,1,0,10));

        JButton pBtn = new JButton("Patients");
        JButton dBtn = new JButton("Doctors");
        JButton aBtn = new JButton("Appointments");
        JButton disBtn = new JButton("Diseases");

        menu.add(pBtn);
        menu.add(dBtn);
        menu.add(aBtn);
        menu.add(disBtn);

        // Panels
        DiseasePanel disPanel = new DiseasePanel();
        PatientPanel pp = new PatientPanel();
        pp.setDiseasePanel(disPanel); // link DiseasePanel for refresh
        DoctorPanel dp = new DoctorPanel(new AppointmentPanel());
        AppointmentPanel ap = new AppointmentPanel();

        // Add panels to mainPanel
        mainPanel.add(pp, "PATIENT");
        mainPanel.add(dp, "DOCTOR");
        mainPanel.add(ap, "APP");
        mainPanel.add(disPanel, "DISEASE");

        add(menu, BorderLayout.WEST);
        add(mainPanel, BorderLayout.CENTER);

        // Button actions to switch panels
        pBtn.addActionListener(e -> layout.show(mainPanel,"PATIENT"));
        dBtn.addActionListener(e -> layout.show(mainPanel,"DOCTOR"));
        aBtn.addActionListener(e -> layout.show(mainPanel,"APP"));
        disBtn.addActionListener(e -> layout.show(mainPanel,"DISEASE"));

        setVisible(true);
    }
}
