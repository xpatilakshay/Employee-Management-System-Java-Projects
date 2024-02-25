package emp;

import java.sql.*;

public class Conn {

    Connection con;
    Statement stm;

    public Conn() {
        try {
            //Register a Driver Class
            Class.forName("com.mysql.cj.jdbc.Driver");
            //connection establish
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Employee_Management_System", "root", "patil@2004");
            stm = con.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new Conn();
    }
}
