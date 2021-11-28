package Payroll;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.ResultSet;

public class Salary extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6,l7;
    JTextField hra, da, med, pf, bs;
    JButton submit, cancel;
    Choice c;

    Salary(){
        super("Set Salary");
        setSize(550, 450);
        setLocation(300, 150);
        setLayout(null);

        l1 = new JLabel("Employee ID");
        l1.setBounds(70, 20, 200, 25);
        add(l1);
        
        c = new Choice();
        c.setBounds(300, 20, 200, 25);
        add(c);
        try {
            Conn con = new Conn();
            ResultSet rs =  con.stmt.executeQuery("Select * from employee");
            while(rs.next()){
                c.add(String.valueOf(rs.getInt("id")));
            }
        }catch (Exception e){e.printStackTrace();}

        l2 = new JLabel("HRA");
        l2.setBounds(70, 70, 200, 25);
        add(l2);

        hra = new JTextField(20);
        hra.setBounds(300, 70, 200, 25);
        add(hra);

        l3 = new JLabel("DA");
        l3.setBounds(70, 120, 200, 25);
        add(l3);

        da = new JTextField(20);
        da.setBounds(300, 120, 200, 25);
        add(da);

        l4 = new JLabel("MED");
        l4.setBounds(70, 170, 200, 25);
        add(l4);

        med = new JTextField(20);
        med.setBounds(300, 170, 200, 25);
        add(med);

        l5 = new JLabel("PF");
        l5.setBounds(70, 220, 200, 25);
        add(l5);

        pf = new JTextField(20);
        pf.setBounds(300, 220, 200, 25);
        add(pf);

        l6 = new JLabel("Basic Salary");
        l6.setBounds(70, 270, 200, 25);
        add(l6);

        bs = new JTextField(20);
        bs.setBounds(300, 270, 200, 25);
        add(bs);

        submit = new JButton("Submit");
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
        submit.setBounds(250, 320, 100, 25);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(250, 370, 100, 25);
        cancel.addActionListener(this);
        add(cancel);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            int id = Integer.parseInt(c.getSelectedItem());
            float hra_ = Float.parseFloat(hra.getText() );
            float da_ = Float.parseFloat(da.getText());
            float med_ = Float.parseFloat(med.getText());
            float pf_ = Float.parseFloat(pf.getText());
            float bs_ = Float.parseFloat(bs.getText());

            try{
                Conn con = new Conn();
                String q = "insert into salary (id, hra, da, med, pf, basic_salary) values ("+id+", "+hra_+", "+da_+", "+med_+", "+pf_+", "+bs_+")";
                con.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
            }catch (Exception e){e.printStackTrace();}
        }else if(ae.getSource() == cancel){
            this.setVisible(false);
        }
    }


    public static void main(String[] args) {
        new Salary().setVisible(true);
    }
}
