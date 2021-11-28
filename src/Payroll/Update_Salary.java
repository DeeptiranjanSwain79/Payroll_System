package Payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Update_Salary extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6,l7;
    JTextField hra, da, med, pf, bs;
    JButton update, delete;
    Choice c;

    Update_Salary(){
        super("Update Salary");
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

        update = new JButton("Update");
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLUE);
        update.setBounds(250, 320, 100, 25);
        update.addActionListener(this);
        add(update);

        delete = new JButton("Delete");
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.RED);
        delete.setBounds(250, 370, 100, 25);
        delete.addActionListener(this);
        add(delete);

    }
    public void actionPerformed(ActionEvent ae){
        int id = Integer.parseInt(c.getSelectedItem());
        float hra_ = Float.parseFloat(c.getSelectedItem());
        float da_ = Float.parseFloat(da.getText());
        float med_ = Float.parseFloat(med.getText());
        float pf_ = Float.parseFloat(pf.getText());
        float bs_ = Float.parseFloat(bs.getText());
        if (ae.getSource() == update){

            try{
                Conn c = new Conn();
                String q = "update salary set hra="+hra_+", da="+da_+", med="+med_+", pf="+pf_+", basic_salary="+bs_+" where id="+id+"";
                c.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Employee data updated successfully");
            }catch (Exception e){e.printStackTrace();}

        }else if (ae.getSource() == delete){
            try{
                Conn c = new Conn();
                String q = "delete from salary where id="+id+"";
                c.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Employee data deleted Successfully");
            }catch (Exception e){e.printStackTrace();}

        }

        try {
            Conn con = new Conn();
            ResultSet rs = con.stmt.executeQuery("Select * from salary where id="+c.getSelectedItem()+"");
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "HRA: "+rs.getString("hra")+"\nDA: "+rs.getString("da")+"\n" +
                        "MED: "+rs.getString("med")+"\nPF: "+rs.getString("pf")+"\nBasic Salary: "+rs.getString("basic_salary")+"");

            }

        }catch (Exception e){e.printStackTrace();}
    }



    public static void main(String[] args) {
        new Update_Salary().setVisible(true);
    }
}
