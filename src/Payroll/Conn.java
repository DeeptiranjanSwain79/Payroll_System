package Payroll;

import java.sql.*;

public class Conn {
    public Connection con;
    public Statement stmt;
    public Conn(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll?characterEncoding=latin1", "root", "Happy");
            stmt = con.createStatement();
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e);
        }
    }
}
