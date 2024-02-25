package emp;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class ViewEmp implements ActionListener {

    JFrame f;
    JTable table;
    Choice EmpID;
    JButton search, print, Update, Back;

    public ViewEmp() {

        f = new JFrame("VIEW EMPLOYEE-Employee Management System");
        f.setSize(1100, 700);
        f.setLocation(350, 120);
        f.setLayout(null);
        f.setResizable(false);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);

        table = new JTable();
        try {
            Conn c = new Conn();
            ResultSet rs = c.stm.executeQuery("select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }

        JScrollPane jsp = new JScrollPane(table);
        jsp.setBackground(Color.orange);
        jsp.setBounds(0, 80, 1100, 700);
        f.add(jsp);

        JLabel lbl = new JLabel("Search Employee By ID : ");
        lbl.setFont(new Font("verdana", Font.BOLD, 14));
        lbl.setBounds(20, 20, 200, 30);
        f.add(lbl);

        EmpID = new Choice();
        EmpID.setBounds(220, 23, 250, 30);
        f.add(EmpID);

        try {
            Conn con = new Conn();
            ResultSet rs = con.stm.executeQuery("select * from employee");
            while (rs.next()) {
                EmpID.add(rs.getString("empid"));
            }

        } catch (Exception ae) {
            ae.printStackTrace();
        }

        search = new JButton("Search");
        search.setBackground(Color.BLACK);
        search.setForeground(Color.WHITE);
        search.setBorderPainted(false);
        search.setFocusPainted(false);
        search.setBounds(480, 20, 100, 30);
        search.addActionListener(this);
        f.add(search);

        print = new JButton("Print");
        print.setBackground(Color.BLACK);
        print.setForeground(Color.WHITE);
        print.setBorderPainted(false);
        print.setFocusPainted(false);
        print.setBounds(590, 20, 100, 30);
        print.addActionListener(this);
        f.add(print);

        Update = new JButton("Update");
        Update.setBackground(Color.BLACK);
        Update.setForeground(Color.WHITE);
        Update.setBorderPainted(false);
        Update.setFocusPainted(false);
        Update.setBounds(700, 20, 100, 30);
        Update.addActionListener(this);
        f.add(Update);

        Back = new JButton("Back");
        Back.setBackground(Color.BLACK);
        Back.setForeground(Color.WHITE);
        Back.setBorderPainted(false);
        Back.setFocusPainted(false);
        Back.setBounds(810, 20, 100, 30);
        Back.addActionListener(this);
        f.add(Back);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Search")) {
            try {
                Conn con = new Conn();
                ResultSet rs = con.stm.executeQuery("select * from employee where empid = '" + EmpID.getSelectedItem() + "'");
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Print")) {
            try {
                table.print();
            } catch (Exception ae) {
                ae.printStackTrace();
            }
        } else if (e.getActionCommand().equals("Back")) {
            f.dispose();
            new MainWindow();
        } else if (e.getActionCommand().equals("Update")) {
            f.dispose();
            new updateEmp(EmpID.getSelectedItem());
        }

    }

    public static void main(String args[]) {
        new ViewEmp();
    }
}
