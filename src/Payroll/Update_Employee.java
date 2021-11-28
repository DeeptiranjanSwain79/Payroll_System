package Payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Update_Employee extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8;
    JTextField name, address, city, state, email, phone, password;
    JButton update, delete;
    Choice c, c1;

    Update_Employee(){
        super("Update Employee");
        setSize(600, 600);
        setLocation(300, 50);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        l8 = new JLabel("ID");
        l8.setBounds(100, 20, 200, 25);
        add(l8);

        c1 = new Choice();
        c1.setBounds(310, 20, 200, 25);
        add(c1);
        try {
            Conn con = new Conn();
            ResultSet rs =  con.stmt.executeQuery("Select * from employee");
            while(rs.next()){
                c1.add(String.valueOf(rs.getInt("id")));
            }
        }catch (Exception e){e.printStackTrace();}

        l1 = new JLabel("Name");
        l1.setBounds(100, 50, 200, 25);
        add(l1);

        name = new JTextField(20);
        name.setBounds(310, 50, 200, 25);
        add(name);

        l2 = new JLabel("Gender");
        l2.setBounds(100, 100, 200, 25);
        add(l2);

        c = new Choice();
        c.add("Male");
        c.add("Female");
        c.setBounds(310, 100, 200, 25);
        add(c);

        l3 = new JLabel("Address");
        l3.setBounds(100, 150, 200, 25);
        add(l3);

        address = new JTextField(20);
        address.setBounds(310, 150, 200, 25);
        add(address);

        l4 = new JLabel("City");
        l4.setBounds(100, 200, 200, 25);
        add(l4);

        city = new JTextField(20);
        city.setBounds(310, 200, 200, 25);
        add(city);

        l5 = new JLabel("State");
        l5.setBounds(100, 250, 200, 25);
        add(l5);

        state = new JTextField(20);
        state.setBounds(310, 250, 200, 25);
        add(state);

        l6 = new JLabel("E-mail");
        l6.setBounds(100, 300, 200, 25);
        add(l6);

        email = new JTextField(20);
        email.setBounds(310, 300, 200, 25);
        add(email);

        l7 = new JLabel("Phone");
        l7.setBounds(100, 350, 200, 25);
        add(l7);

        phone = new JTextField(20);
        phone.setBounds(310, 350, 200, 25);
        add(phone);


        update = new JButton("Update");
        update.setBounds(200, 400, 100, 30);
        update.setForeground(Color.WHITE);
        update.setBackground(Color.BLUE);
        update.addActionListener(this);
        add(update);

        delete = new JButton("Delete");
        delete.setBounds(200, 450, 100, 30);
        delete.setForeground(Color.WHITE);
        delete.setBackground(Color.RED);
        delete.addActionListener(this);
        add(delete);

    }
    public void actionPerformed(ActionEvent ae){
        String name_ = name.getText();
        String gender_ = c.getSelectedItem();
        String address_ = address.getText();
        String city_ = city.getText();
        String state_ = state.getText();
        String email_ = email.getText();
        long phone_ = Long.parseLong(phone.getText());
        int id = Integer.parseInt(c1.getSelectedItem());

        if (ae.getSource() == update){
            try{
                Conn c = new Conn();
                String q = "update employee set name='"+name_+"', gender='"+gender_+"', address='"+address_+"', city='"+city_+"', state='"+state_+"', email='"+email_+"', phone="+phone_+" where id="+id+"";
                c.stmt.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Employee data updated");

            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == delete){
            try{
                Conn c = new Conn();
                c.stmt.executeUpdate("delete from employee where id="+id+"");
            }catch (Exception e){e.printStackTrace();}
        }

        try{
            Conn c = new Conn();
            ResultSet rs = c.stmt.executeQuery("select * from employee where id="+c1.getSelectedItem()+"");
            if (rs.next()){
                JOptionPane.showMessageDialog(null, "Name: "+rs.getString("name")+"\nAddress: "+rs.getString("address")+
                        "\nCity: "+rs.getString("city")+"\nState: "+rs.getString("state")+"\nE-mail: "+rs.getString("email")+"" +
                        "\nPhone: "+rs.getString("phone")+"");

            }
        }catch (Exception e){e.printStackTrace();}
    }

    public static void main(String[] args) {
        new Update_Employee().setVisible(true);
    }
}
