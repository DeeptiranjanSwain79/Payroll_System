package Payroll;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.Random;

public class New_Employee extends JFrame implements ActionListener {
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    JTextField name, address, city, state, email, phone, password;
    JButton submit, cancel;
    Choice c;

    Random ran = new Random();
    long id = Math.abs(ran.nextLong() % 100000L);


    New_Employee(){
        super("New Employee");
        setSize(600, 650);
        setLocation(300, 50);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel title = new JLabel("New Employee Registration", JLabel.CENTER);
        title.setBounds(0, 10, 600, 35);
        title.setFont(new Font("Elephant", Font.BOLD, 30));
        add(title);

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

        l8 = new JLabel("ID");
        l8.setBounds(100, 400, 200, 25);
        add(l8);

        l9 = new JLabel(String.valueOf(id));
        l9.setBounds(310, 400, 200, 25);
        add(l9);

        l10 = new JLabel("Password");
        l10.setBounds(100, 450, 200, 25);
        add(l10);

        password = new JTextField(20);
        password.setBounds(310, 450, 200, 25);
        add(password);

        submit = new JButton("Submit");
        submit.setBounds(200, 500, 100, 30);
        submit.setForeground(Color.WHITE);
        submit.setBackground(Color.BLUE);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(200, 550, 100, 30);
        cancel.setForeground(Color.WHITE);
        cancel.setBackground(Color.BLACK);
        cancel.addActionListener(this);
        add(cancel);

    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == submit){
            String name_ = name.getText();
            String gender_ = c.getSelectedItem();
            String address_ = address.getText();
            String city_ = city.getText();
            String state_ = state.getText();
            String email_ = email.getText();
            long phone_ = Long.parseLong(phone.getText());
            String password_ = password.getText();

            try{
                Conn con = new Conn();
                //Inserting values to login table
                String q1 = "insert into login (id, password) values ("+id+", '"+password_+"')";
                //Inserting values to employee table
                String q2 = "insert into employee (id, password, Name, gender, address, city, state, email, phone) values" +
                        "("+id+", '"+password_+"', '"+name_+"', '"+gender_+"', '"+address_+"', '"+city_+"', '"+state_+"', '"+email_+"', "+phone_+")";
                
                con.stmt.executeUpdate(q1);
                con.stmt.executeUpdate(q2);
                JOptionPane.showMessageDialog(null, "Data Inserted Successfully");
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == cancel){
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new New_Employee().setVisible(true);
    }
}
