package emp;

import java.awt.Color;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.sql.*;
import java.util.*;

public class updateEmp implements ActionListener {

    JFrame f;
    JLabel lbl, namelbl, fnamelbl, dob, salary, addresslbl, phonelbl, emaillbl, edulbl, designationlbl,
            Adharlbl, empIDlbl, empIDlbl1, joinlbl;
    JTextField nameField, eduFeild,
            fnameField, SalaryField, addressField, phoneFeild, emailField, DesignationField, AdharFeild;
    JButton Add, back;
    JDateChooser joinfield;
    String EmpID;
    Random ran = new Random();
    int number = ran.nextInt(999999);

    public updateEmp(String EmpID) {

        this.EmpID = EmpID;
        //Setting up Frsme
        f = new JFrame("ADD EMPLOYEE-Employee Management System");
        f.setSize(1100, 700);
        f.setLocation(350, 120);
        f.setLayout(null);
        f.setResizable(false);

        f.setVisible(true);

        lbl = new JLabel("Update Employee Details...");
        lbl.setFont(new Font("verdana", Font.BOLD, 28));
        lbl.setBounds(300, 30, 500, 40);
        f.add(lbl);

        namelbl = new JLabel("Name : ");
        namelbl.setFont(new Font("verdana", Font.BOLD, 22));
        namelbl.setBounds(50, 120, 250, 40);
        f.add(namelbl);

        JLabel name = new JLabel();
        name.setBounds(150, 120, 300, 40);
        name.setFont(new Font("verdana", Font.BOLD, 20));
        f.add(name);

        fnamelbl = new JLabel("Father's Name : ");
        fnamelbl.setFont(new Font("verdana", Font.BOLD, 22));
        fnamelbl.setBounds(480, 120, 300, 40);
        f.add(fnamelbl);

        fnameField = new JTextField();
        fnameField.setBounds(700, 120, 300, 40);
        fnameField.setFont(new Font("verdana", Font.BOLD, 20));
        f.add(fnameField);

        dob = new JLabel("Date of Birth : ");
        dob.setFont(new Font("verdana", Font.BOLD, 22));
        dob.setBounds(50, 180, 260, 40);
        f.add(dob);

        JLabel doblbl = new JLabel();
        doblbl.setFont(new Font("verdana", Font.BOLD, 18));
        doblbl.setBounds(240, 180, 210, 40);
        f.add(doblbl);

        salary = new JLabel("Salary : ");
        salary.setFont(new Font("verdana", Font.BOLD, 20));
        salary.setBounds(480, 180, 300, 40);
        f.add(salary);

        SalaryField = new JTextField();
        SalaryField.setBounds(700, 180, 300, 40);
        SalaryField.setFont(new Font("verdana", Font.BOLD, 20));
        f.add(SalaryField);

        addresslbl = new JLabel("Address : ");
        addresslbl.setFont(new Font("verdana", Font.BOLD, 20));
        addresslbl.setBounds(50, 240, 300, 40);
        f.add(addresslbl);

        addressField = new JTextField();
        addressField.setBounds(180, 240, 270, 40);
        addressField.setFont(new Font("verdana", Font.BOLD, 20));
        f.add(addressField);

        phonelbl = new JLabel("Phone No : ");
        phonelbl.setFont(new Font("verdana", Font.BOLD, 22));
        phonelbl.setBounds(480, 240, 300, 40);
        f.add(phonelbl);

        phoneFeild = new JTextField();
        phoneFeild.setBounds(700, 240, 300, 40);
        phoneFeild.setFont(new Font("verdana", Font.BOLD, 20));
        f.add(phoneFeild);

        emaillbl = new JLabel("Email ID : ");
        emaillbl.setFont(new Font("verdana", Font.BOLD, 20));
        emaillbl.setBounds(50, 300, 300, 40);
        f.add(emaillbl);

        emailField = new JTextField();
        emailField.setBounds(180, 300, 270, 40);
        emailField.setFont(new Font("verdana", Font.BOLD, 20));
        f.add(emailField);

        edulbl = new JLabel("Education : ");
        edulbl.setFont(new Font("verdana", Font.BOLD, 22));
        edulbl.setBounds(480, 300, 300, 40);
        f.add(edulbl);

        eduFeild = new JTextField();
        eduFeild.setBounds(700, 300, 300, 40);
        eduFeild.setFont(new Font("verdana", Font.BOLD, 20));
        f.add(eduFeild);

        designationlbl = new JLabel("Designation : ");
        designationlbl.setFont(new Font("verdana", Font.BOLD, 20));
        designationlbl.setBounds(50, 360, 300, 40);
        f.add(designationlbl);

        DesignationField = new JTextField();
        DesignationField.setBounds(220, 360, 230, 40);
        DesignationField.setFont(new Font("verdana", Font.BOLD, 20));
        f.add(DesignationField);

        Adharlbl = new JLabel("Aadhar No : ");
        Adharlbl.setFont(new Font("verdana", Font.BOLD, 22));
        Adharlbl.setBounds(480, 360, 300, 40);
        f.add(Adharlbl);

        JLabel Adharlbl = new JLabel();
        Adharlbl.setBounds(700, 360, 300, 40);
        Adharlbl.setFont(new Font("verdana", Font.BOLD, 20));
        f.add(Adharlbl);

        empIDlbl = new JLabel("Employee ID : ");
        empIDlbl.setFont(new Font("verdana", Font.BOLD, 20));
        empIDlbl.setBounds(50, 420, 300, 40);
        f.add(empIDlbl);

        empIDlbl1 = new JLabel();
        empIDlbl1.setFont(new Font("verdana", Font.BOLD, 20));
        empIDlbl1.setBounds(220, 420, 300, 40);
        f.add(empIDlbl1);

        joinlbl = new JLabel("Date of Join : ");
        joinlbl.setFont(new Font("verdana", Font.BOLD, 22));
        joinlbl.setBounds(480, 420, 260, 40);
        f.add(joinlbl);

        JLabel joinedtlbl = new JLabel();
        joinedtlbl.setFont(new Font("verdana", Font.BOLD, 18));
        joinedtlbl.setBounds(700, 420, 210, 40);
        f.add(joinedtlbl);

        try {
            Conn c = new Conn();
            String query = "Select * from employee where empid = '" + EmpID + "'";
            ResultSet rs = c.stm.executeQuery(query);
            while (rs.next()) {
                name.setText(rs.getString("name"));
                fnameField.setText(rs.getString("fname"));
                doblbl.setText(rs.getString("dob"));
                SalaryField.setText(rs.getString("salary"));
                addressField.setText(rs.getString("address"));
                phoneFeild.setText(rs.getString("phone"));
                emailField.setText(rs.getString("email"));
                eduFeild.setText(rs.getString("education"));
                DesignationField.setText(rs.getString("designation"));
                Adharlbl.setText(rs.getString("aadhar"));
                empIDlbl1.setText(rs.getString("empid"));
                joinedtlbl.setText(rs.getString("doj"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        back = new JButton("Back");
        back.setBorderPainted(false);
        back.setFocusPainted(false);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(250, 520, 100, 40);
        back.addActionListener(this);
        f.add(back);

        Add = new JButton("Update Data");
        Add.setBorderPainted(false);
        Add.setFocusPainted(false);
        Add.setBackground(Color.BLACK);
        Add.setForeground(Color.WHITE);
        Add.setBounds(750, 520, 150, 40);
        Add.addActionListener(this);
        f.add(Add);

        ImageIcon imgbg = new ImageIcon("D:\\Study\\Java\\EMP\\src\\emp\\images\\bg.png");
        Image imgbgfinal = imgbg.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon1 = new ImageIcon(imgbgfinal);

        JLabel imglblbg = new JLabel(scaledImageIcon1);
        imglblbg.setBounds(0, 0, 1100, 700);
        f.add(imglblbg);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Back")) {
            f.dispose();
            new MainWindow();
        } else if (e.getActionCommand().equals("Update Data")) {

            String fname = fnameField.getText();
            String salary = SalaryField.getText();
            String address = addressField.getText();
            String phone = phoneFeild.getText();
            String email = emailField.getText();
            String designation = DesignationField.getText();
            String education = eduFeild.getText();

            try {
                Conn con = new Conn();
                String query = "update employee set fname = '" + fname + "',salary = '" + salary + "',address = '" + address + "',phone = '" + phone + "',email = '"
                        + email + "',education = '" + education + "',designation = '" + designation + "' where empid = '" + EmpID + "' ";
                con.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Data Successfully Updated");
                f.setVisible(false);
                new MainWindow();
            } catch (Exception exc) {
                exc.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new updateEmp("");
    }
}
