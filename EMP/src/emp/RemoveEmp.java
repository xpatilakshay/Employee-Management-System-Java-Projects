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
import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.util.*;

public class RemoveEmp implements ActionListener {

    JFrame f;
    Choice cempid;
    JButton Backbtn, Delbtn;

    public RemoveEmp() {
        //Setting up Frsme
        f = new JFrame("Remove EMPLOYEE-Employee Management System");
        f.setSize(900, 550);
        f.setLocation(350, 120);
        f.setLayout(null);
        f.setResizable(false);
      
        f.setVisible(true);

        JLabel empidlbl = new JLabel("Employee ID : ");
        empidlbl.setFont(new Font("verdana", Font.BOLD, 22));
        empidlbl.setBounds(50, 50, 200, 40);
        f.add(empidlbl);

        cempid = new Choice();
        cempid.setFont(new Font("verdana", Font.BOLD, 22));
        cempid.setBounds(250, 50, 300, 40);
        f.add(cempid);

        try {
            Conn c = new Conn();
            String query = "Select * from employee";
            ResultSet rs = c.stm.executeQuery(query);
            while (rs.next()) {
                cempid.add(rs.getString("empid"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel labelName = new JLabel("Name : ");
        labelName.setFont(new Font("verdana", Font.BOLD, 22));
        labelName.setBounds(50, 100, 200, 40);
        f.add(labelName);

        JLabel Namelbl = new JLabel();
        Namelbl.setFont(new Font("verdana", Font.BOLD, 22));
        Namelbl.setBounds(250, 100, 300, 40);
        f.add(Namelbl);

        JLabel labelphone = new JLabel("Phone : ");
        labelphone.setFont(new Font("verdana", Font.BOLD, 22));
        labelphone.setBounds(50, 150, 200, 40);
        f.add(labelphone);

        JLabel phonelbl = new JLabel();
        phonelbl.setFont(new Font("verdana", Font.BOLD, 22));
        phonelbl.setBounds(250, 150, 300, 40);
        f.add(phonelbl);

        JLabel labelemail = new JLabel("Email : ");
        labelemail.setFont(new Font("verdana", Font.BOLD, 22));
        labelemail.setBounds(50, 200, 200, 40);
        f.add(labelemail);

        JLabel emaillbl = new JLabel();
        emaillbl.setFont(new Font("verdana", Font.BOLD, 22));
        emaillbl.setBounds(250, 200, 300, 40);
        f.add(emaillbl);

        try {
            Conn c = new Conn();
            String query = "Select * from employee where empid ='" + cempid.getSelectedItem() + "'";
            ResultSet rs = c.stm.executeQuery(query);
            while (rs.next()) {
                Namelbl.setText(rs.getString("name"));
                phonelbl.setText(rs.getString("phone"));
                emaillbl.setText(rs.getString("email"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Backbtn = new JButton("Back");
        Backbtn.setBackground(Color.BLACK);
        Backbtn.setForeground(Color.WHITE);
        Backbtn.setBorderPainted(false);
        Backbtn.setFocusPainted(false);
        Backbtn.setBounds(100, 320, 100, 40);
        Backbtn.addActionListener(this);
        f.add(Backbtn);

        Delbtn = new JButton("Remove");
        Delbtn.setBackground(Color.BLACK);
        Delbtn.setForeground(Color.WHITE);
        Delbtn.setBorderPainted(false);
        Delbtn.setFocusPainted(false);
        Delbtn.setBounds(300, 320, 100, 40);
        Delbtn.addActionListener(this);
        f.add(Delbtn);

        ImageIcon imgremv = new ImageIcon("D:\\Study\\Java\\EMP\\src\\emp\\images\\remove.png");
        Image imgfinal = imgremv.getImage().getScaledInstance(300, 230, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon = new ImageIcon(imgfinal);

        JLabel imglbl = new JLabel(scaledImageIcon);
        imglbl.setBounds(550, 100, 300, 230);
        f.add(imglbl);

        ImageIcon imgbg = new ImageIcon("D:\\Study\\Java\\EMP\\src\\emp\\images\\bg.png");
        Image imgbgfinal = imgbg.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon1 = new ImageIcon(imgbgfinal);

        JLabel imglblbg = new JLabel(scaledImageIcon1);
        imglblbg.setBounds(0, 0, 1100, 700);
        f.add(imglblbg);

        cempid.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "Select * from employee where empid ='" + cempid.getSelectedItem() + "'";
                    ResultSet rs = c.stm.executeQuery(query);
                    while (rs.next()) {
                        Namelbl.setText(rs.getString("name"));
                        phonelbl.setText(rs.getString("phone"));
                        emaillbl.setText(rs.getString("email"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Back")) {
            f.dispose();
            new MainWindow();
        } else if (ae.getActionCommand().equals("Remove")) {
            try {
                Conn c = new Conn();
                String query = "delete from employee where empid = '" + cempid.getSelectedItem() + "'";
                c.stm.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Removed Successfully!..");
                f.dispose();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        new RemoveEmp();
    }
}
