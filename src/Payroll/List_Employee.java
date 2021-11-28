package Payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class List_Employee extends JFrame implements ActionListener {
    JTable t;
    JButton print;
    String h[] = {"Emp ID", "Name", "Gender", "Address", "State", "City", "Email", "Phone"};
    String d[][] = new String[40][8];
    int i=0, j=0;

    List_Employee(){
        super("View Employee List");
        setSize(1000, 400);
        setLocation(200, 200);

        try{
            Conn c = new Conn();
            ResultSet rs =  c.stmt.executeQuery("Select * from employee");
            while (rs.next()){
                d[i][j++] = rs.getString("id");
                d[i][j++] = rs.getString("name");
                d[i][j++] = rs.getString("gender");
                d[i][j++] = rs.getString("address");
                d[i][j++] = rs.getString("city");
                d[i][j++] = rs.getString("state");
                d[i][j++] = rs.getString("email");
                d[i][j++] = rs.getString("phone");
                i++;
                j=0;
            }

            t = new JTable(d, h);
            JScrollPane sp = new JScrollPane(t);
            add(sp);


        }catch (Exception e){e.printStackTrace();}

        print = new JButton("Print");
        print.setForeground(Color.WHITE);
        print.setBackground(Color.BLUE);
        print.addActionListener(this);
        add(print, "South");

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == print){
            try {
                t.print();
            }catch (Exception e){e.printStackTrace();}
        }
    }

    public static void main(String[] args) {
        new List_Employee().setVisible(true);
    }
}
