package Hospital_Management_System;
import javax.swing.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setTitle("Hospital Login");
        setSize(300,200);
        setLayout(null);
        JLabel l1 = new JLabel("Username:");
        JLabel l2 = new JLabel("Password:");
        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();
        JButton btn = new JButton("Login");
        l1.setBounds(10,30,70,25);
        l2.setBounds(10,70,70,25);
        user.setBounds(80,30,140,25);
        pass.setBounds(80,70,140,25);
        btn.setBounds(100,110,100,30);
        add(l1); add(l2);
        add(user); add(pass); add(btn);
        btn.addActionListener(e -> {
            String username = user.getText();
            String password = String.valueOf(pass.getPassword());
            if(username.equals("admin") && password.equals("1234")) {
                dispose();
                new DashboardFrame();
            }
            else {
                JOptionPane.showMessageDialog(this,
                        "Invalid Username or Password");
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
