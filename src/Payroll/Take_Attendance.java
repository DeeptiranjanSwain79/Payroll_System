package Payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Take_Attendance extends JFrame implements ActionListener {
    JLabel l1, l2, l3;
    Choice c, f, s;
    JButton submit, cancel;

    Take_Attendance(){
        super("Attendance");
        setLayout(null);
        setSize(600, 300);
        setLocation(300, 150);

        l1 = new JLabel("Employee ID");
        l1.setBounds(50, 20, 200, 25);
        add(l1);

        c = new Choice();
        c.setBounds(300, 20, 200, 25);
        add(c);
        try{
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("select * from employee");
            while (rs.next()){
                c.add(rs.getString("id"));
            }
        }catch (Exception e){e.printStackTrace();}

        l2 = new JLabel("First Half");
        l2.setBounds(50, 70, 200, 25);
        add(l2);

        f = new Choice();
        f.setBounds(300, 70, 200, 25);
        f.add("Present");
        f.add("Absent");
        f.add("Leave");
        add(f);

        l3 = new JLabel("Second Half");
        l3.setBounds(50, 120, 200, 25);
        add(l3);

        s = new Choice();
        s.setBounds(300, 120, 200, 25);
        s.add("Present");
        s.add("Absent");
        s.add("Leave");
        add(s);

        submit = new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
        submit.setBounds(250, 150, 100, 25);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(250, 180, 100, 25);
        cancel.addActionListener(this);
        add(cancel);

    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            int id = Integer.parseInt(c.getSelectedItem());
            String fh = f.getSelectedItem();
            String sh = s.getSelectedItem();
            String dt = new java.util.Date().toString();

            try{
                Conn con = new Conn();
                con.stmt.executeUpdate("insert into attendance (id, date_tm, f_half, s_half) values ("+id+", '"+dt+"', '"+fh+"', '"+sh+"')");
                JOptionPane.showMessageDialog(null, "Attendance taken Successfully");
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == cancel){
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new Take_Attendance().setVisible(true);
    }
}
