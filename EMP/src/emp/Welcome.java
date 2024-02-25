package emp;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Welcome implements ActionListener {

    JFrame f;

    public Welcome() {

        //Setting up Frsme
        f = new JFrame("Welcome-Employee Management System");
        f.setSize(800, 700);
        f.setLocation(350, 120);
        f.setLayout(null);
        f.setResizable(false);
        

        //Label
        JLabel Wlc = new JLabel("Welcome To Employee Management System");
        Wlc.setForeground(Color.BLACK);
        Wlc.setBounds(90, 200, 700, 30);
        Wlc.setFont(new Font("Arial", Font.BOLD, 30));
        f.add(Wlc);

        // Button
        JButton btn = new JButton("Click here to Continue...");
        btn.setBounds(260, 300, 270, 50);
        btn.setFont(new Font("Arial", Font.BOLD, 20));
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.white);
        btn.addActionListener(this);
        f.add(btn);

        ImageIcon img = new ImageIcon("D:\\Study\\Java\\EMP\\src\\emp\\images\\wlc.png");
        Image img1 = img.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon = new ImageIcon(img1);

        JLabel imglbl = new JLabel(scaledImageIcon);
        imglbl.setBounds(250, 350, 300, 300);
        f.add(imglbl);

        ImageIcon imgbg = new ImageIcon("D:\\Study\\Java\\EMP\\src\\emp\\images\\bg.png");
        Image imgbgfinal = imgbg.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon scaledImageIcon1 = new ImageIcon(imgbgfinal);

        JLabel imglblbg = new JLabel(scaledImageIcon1);
        imglblbg.setBounds(0, 0, 800, 700);
        f.add(imglblbg);

        f.setVisible(true);
    }

    public static void main(String args[]) {
        new Welcome();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        f.dispose();
        new Login();
    }

}
