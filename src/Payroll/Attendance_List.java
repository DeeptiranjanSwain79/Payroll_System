package Payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Attendance_List extends JFrame implements ActionListener {
    JTable t;
    JButton print;
    String h[] = {"Employee ID", "Date", "First Half", "Second Half"};
    String d[][] = new String[20][4];
    int i=0, j=0;
    Attendance_List(){
        super("View Attendance List");
        setSize(800, 300);
        setLocation(100, 200);


        try {
            Conn con = new Conn();
            ResultSet rs =  con.stmt.executeQuery("Select * from attendance");
            System.out.println(rs);
            while (rs.next()) {
                d[i][j++] = rs.getString("id");
                d[i][j++] = rs.getString("date_tm");
                d[i][j++] = rs.getString("f_half");
                d[i][j++] = rs.getString("s_half");
                i++;
                j = 0;
            }
            t = new JTable(d,h);
        }catch (Exception e){e.printStackTrace();}
        JScrollPane sp = new JScrollPane(t);
        add(sp);



        print = new JButton("Print");
        print.setForeground(Color.WHITE);
        print.setBackground(Color.GREEN);
        print.addActionListener(this);
        add(print, "South");


    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == print){
            try{
                t.print();
            }catch (Exception e){e.printStackTrace();}
        }
    }

    public static void main(String[] args) {
        new Attendance_List().setVisible(true);
    }
}
