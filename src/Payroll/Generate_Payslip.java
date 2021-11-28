package Payroll;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;
import java.text.DateFormatSymbols;
import java.util.Locale;

public class Generate_Payslip extends JFrame implements ActionListener {
    Choice c;
    JLabel l1;
    JTextArea ta;
    JButton generate;

    Generate_Payslip(){
        setSize(550, 700);
        setLocation(300, 50);
        setLayout(new BorderLayout());

        l1 = new JLabel("Employee ID");
//        l1.setBounds(50, 10, 200, 25);

        c = new Choice();
//        c.setBounds(300, 10, 200, 25);

        try{
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("Select * from Salary");
            while (rs.next()){
                c.add(rs.getString("id"));
            }
        }catch(Exception e){e.printStackTrace();}

        ta = new JTextArea(100, 80);
        ta.setText("\n\n\s\s\s\s\s\s\s\s\sClick on the Generate Pay Slip Button to\n\tto get the Payslip");
        JScrollPane sp = new JScrollPane(ta);
        ta.setFont(new Font("monospaced", Font.BOLD, 16));
        sp.setBounds(0, 40, 550, 600);



        generate = new JButton("Generate Pay Slip");
        generate.setBackground(Color.GREEN);
        generate.setForeground(Color.WHITE);
        generate.addActionListener(this);
        generate.setBounds(0, 670, 550, 30);

        add(l1);
        add(c);
        add(sp, "Center");
        add(generate, "South");
    }

    public void actionPerformed(ActionEvent ae){
        try {
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("Select * from employee where id='"+c.getSelectedItem()+"'");
            rs.next();
            String name = rs.getString("Name");
            rs.close();

            rs = con.stmt.executeQuery("Select * from Salary where id='"+c.getSelectedItem()+"'");
            double gross = 0, net = 0;

            java.util.Date d = new java.util.Date();
            String month = new DateFormatSymbols().getMonths()[d.getMonth()];   //import java.text.DateFormatSymbols;
//            System.out.println(month);

            ta.setText("\n\n\n\n----------PAY SLIP FOR THE MONTH "+month.toUpperCase()+", 2021----------");
            ta.append("\n");
            //setText() is used to print something in the components but  append() is unique to JTextArea

            if (rs.next()){
                ta.append("\n       Employee ID :"+rs.getString("id")+"");
                ta.append("\n       Employee Name : "+name);
                ta.append("\n----------------------------------------------------------------------------------------------\n");

                double hra = rs.getDouble("hra");
                ta.append("\n       HRA : "+hra);
                double da = rs.getDouble("da");
                ta.append("\n       DA : "+da);
                double med = rs.getDouble("med");
                ta.append("\n       MED : "+med);
                double pf = rs.getDouble("pf");
                ta.append("\n       PF : "+pf);
                double bs = rs.getDouble("basic_salary");
                ta.append("\n       Basic Salary : "+bs);
                gross = hra + da+ med + pf + bs;
                net = gross - pf;

                ta.append("\n\n----------------------------------------------------------------------------------------------\n");
                ta.append("\n       GROSS SALARY : "+gross);
                ta.append("\n       NET SALARY : "+net);
                ta.append("\n       Tax : "+(gross*2.1/100));


            }

        }catch (Exception e){e.printStackTrace();}

    }

    public static void main(String[] args) {
        new Generate_Payslip().setVisible(true);
    }
}
