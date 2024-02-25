package emp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow implements ActionListener {

    JFrame f;

    public MainWindow() {
        //Setting up Frsme
        f = new JFrame("Home-Employee Management System");
        f.setSize(800, 700);
        f.setLocation(350, 120);
        f.setLayout(null);
        f.setResizable(false);
        
        f.setVisible(true);

        JLabel title = new JLabel("Please Select The Operation...");
        title.setFont(new Font("verdana", Font.BOLD, 28));
        title.setForeground(Color.BLACK);
        title.setBounds(150, 50, 500, 40);
        f.add(title);

        JButton addEmp = new JButton("Add Employee");
        addEmp.setBorderPainted(false);
        addEmp.setFocusPainted(false);
        addEmp.setBackground(Color.BLACK);
        addEmp.setForeground(Color.WHITE);
        addEmp.setBounds(290, 150, 200, 40);
        addEmp.addActionListener(this);
        f.add(addEmp);

        JButton updateEmp = new JButton("Update Employee");
        updateEmp.setBorderPainted(false);
        updateEmp.setFocusPainted(false);
        updateEmp.setBackground(Color.BLACK);
        updateEmp.setForeground(Color.WHITE);
        updateEmp.setBounds(290, 220, 200, 40);
        updateEmp.addActionListener(this);
        f.add(updateEmp);

        JButton delEmp = new JButton("Remove Employee");
        delEmp.setBorderPainted(false);
        delEmp.setFocusPainted(false);
        delEmp.setBackground(Color.BLACK);
        delEmp.setForeground(Color.WHITE);
        delEmp.setBounds(290, 290, 200, 40);
        delEmp.addActionListener(this);
        f.add(delEmp);

        JButton showEmp = new JButton("View Employee");
        showEmp.setBorderPainted(false);
        showEmp.setFocusPainted(false);
        showEmp.setBackground(Color.BLACK);
        showEmp.setForeground(Color.WHITE);
        showEmp.setBounds(290, 360, 200, 40);
        showEmp.addActionListener(this);
        f.add(showEmp);

        JButton Backbtn = new JButton("Back");
        Backbtn.setBorderPainted(false);
        Backbtn.setFocusPainted(false);
        Backbtn.setBackground(Color.BLACK);
        Backbtn.setForeground(Color.WHITE);
        Backbtn.setBounds(290, 430, 200, 40);
        Backbtn.addActionListener(this);
        f.add(Backbtn);

        ImageIcon img = new ImageIcon("D:\\Study\\Java\\EMP\\src\\emp\\images\\emp.png");
        Image img1 = img.getImage().getScaledInstance(230, 230, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon = new ImageIcon(img1);

        JLabel imglbl = new JLabel(scaledImageIcon);
        imglbl.setBounds(490, 180, 300, 250);
        f.add(imglbl);

        ImageIcon img2 = new ImageIcon("D:\\Study\\Java\\EMP\\src\\emp\\images\\setting.png");
        Image img3 = img2.getImage().getScaledInstance(230, 230, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon1 = new ImageIcon(img3);

        JLabel imglbl1 = new JLabel(scaledImageIcon1);
        imglbl1.setBounds(20, 180, 300, 250);
        f.add(imglbl1);

        ImageIcon imgbg = new ImageIcon("D:\\Study\\Java\\EMP\\src\\emp\\images\\bg.png");
        Image imgbgfinal = imgbg.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon2 = new ImageIcon(imgbgfinal);

        JLabel imglblbg = new JLabel(scaledImageIcon2);
        imglblbg.setBounds(0, 0, 800, 700);
        f.add(imglblbg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Add Employee")) {
            f.dispose();
            new AddEmp();

        } else if (e.getActionCommand().equals("Update Employee")) {
            new ViewEmp();
            f.dispose();

        } else if (e.getActionCommand().equals("Remove Employee")) {
            new RemoveEmp();
        } else if (e.getActionCommand().equals("View Employee")) {
            new ViewEmp();
        } else if (e.getActionCommand().equals("Back")) {

            new Login();
            f.dispose();
        }

    }

    public static void main(String args[]) {
        new MainWindow();
    }
}
