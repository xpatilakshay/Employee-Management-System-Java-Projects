package emp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login implements ActionListener {

    JTextField usernameField;
    JPasswordField passwordField;
    JFrame f;

    public Login() {
        f = new JFrame("Login - Employee Management System");
        f.setVisible(true);
        f.setLocation(350, 120);
        f.setSize(800, 400);
        f.setResizable(false);
        f.setLayout(null);
        

        JLabel usernameLabel = new JLabel("Username: ");
        usernameLabel.setBounds(150, 80, 200, 40);
        usernameLabel.setFont(new Font("verdana", Font.BOLD, 16));
        f.add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setFont(new Font("verdana", Font.BOLD, 16));
        usernameField.setBounds(270, 80, 210, 40);
        f.add(usernameField);

        JLabel passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(150, 140, 200, 40);
        passwordLabel.setFont(new Font("verdana", Font.BOLD, 16));
        f.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("verdana", Font.BOLD, 16));
        passwordField.setBounds(270, 140, 210, 40);
        f.add(passwordField);

        JButton backbtn = new JButton("Back");
        backbtn.setBorderPainted(false);
        backbtn.setFocusPainted(false);
        backbtn.setBackground(Color.BLACK);
        backbtn.setForeground(Color.white);
        backbtn.setBounds(270, 200, 100, 40);
        backbtn.addActionListener(this);
        f.add(backbtn);

        JButton loginbtn = new JButton("Login");
        loginbtn.setBorderPainted(false);
        loginbtn.setFocusPainted(false);
        loginbtn.setBackground(Color.BLACK);
        loginbtn.setForeground(Color.white);
        loginbtn.setBounds(380, 200, 100, 40);
        loginbtn.addActionListener(this);
        f.add(loginbtn);

        ImageIcon img = new ImageIcon("D:\\Study\\Java\\EMP\\src\\emp\\images\\login.png");
        Image img1 = img.getImage().getScaledInstance(230, 230, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon = new ImageIcon(img1);

        JLabel imglbl = new JLabel(scaledImageIcon);
        imglbl.setBounds(500, 65, 200, 200);
        f.add(imglbl);

        ImageIcon imgbg = new ImageIcon("D:\\Study\\Java\\EMP\\src\\emp\\images\\bg.png");
        Image imgbgfinal = imgbg.getImage().getScaledInstance(800, 400, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon1 = new ImageIcon(imgbgfinal);

        JLabel imglblbg = new JLabel(scaledImageIcon1);
        imglblbg.setBounds(0, 0, 800, 400);
        f.add(imglblbg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            new Welcome();
            f.dispose();
        } else if (e.getActionCommand().equals("Login")) {

            try {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                String query = "select * from login where username = '" + username + "'and password = '" + password + "'";
                Conn con = new Conn();
                ResultSet rs = con.stm.executeQuery(query);
                if (rs.next()) {
                    f.setVisible(false);
                    new MainWindow();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                }
            } catch (Exception exc) {
                exc.printStackTrace();
            }

        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
