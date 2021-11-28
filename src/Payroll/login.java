package Payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class login extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField tf;
    JPasswordField pf;
    JButton login, cancel;
    login(){
        super("Login Page");
        setSize(600, 270);
        setLocation(300, 200);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        l1 = new JLabel("ID");
        l1.setBounds(250, 20, 200, 20);
        add(l1);

        l2 = new JLabel("Password");
        l2.setBounds(250, 70, 200, 20);
        add(l2);

        tf = new JTextField(15);
        tf.setBounds(370, 20, 200, 20);
        add(tf);

        pf = new JPasswordField(15);
        pf.setBounds(370, 70, 200, 20);
        pf.setVisible(true);
        add(pf);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/login.png"));
        login = new JButton("Log in", new ImageIcon(i1.getImage()));
        login.setBounds(350, 110, 100, 25);
        add(login);

        ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("icon/cancel.png"));
        cancel = new JButton("Cancel", new ImageIcon(i2.getImage()));
        cancel.setBounds(350, 180, 100, 25);
        add(cancel);

        login.addActionListener(this);
        cancel.addActionListener(this);

        ImageIcon i = new ImageIcon(ClassLoader.getSystemResource("icon/defaultpic.png"));
        Image img = i.getImage();
        JLabel il = new JLabel(new ImageIcon(img));
        il.setBounds(50, 50, 130, 130);
        add(il);
    }

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == login){
            try{
                int id = Integer.parseInt(tf.getText());
                String password = pf.getText();

                Conn c = new Conn();
                String q = "select * from login where id="+id+" and password='"+password+"'";
                ResultSet rs = c.stmt.executeQuery(q);
                System.out.println(q);

                if(rs.next()){
                new Project().setVisible(true);
                    this.setVisible(false);
                }else{
                    JOptionPane.showMessageDialog(null, "Invalid Credentials");
                }
            }catch (Exception e){e.printStackTrace();}
        }else if (ae.getSource() == cancel){
            this.setVisible(false);
        }

    }

    public static void main(String[] args) {
        new login().setVisible(true);
    }
}
