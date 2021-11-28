package Payroll;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {
    Project(){
        super("Payroll System");
        setLayout(new FlowLayout());
//        setLocation(40, 30);
        setSize(1530, 820);
        setFont(new Font("Elephant", Font.PLAIN, 21));
        getContentPane().setBackground(Color.CYAN);

        //Adding background image
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("icon/bg.png"));
        Image i1 = ic.getImage().getScaledInstance(1500, 800, Image.SCALE_DEFAULT);
        ImageIcon b = new ImageIcon(i1);
        JLabel bg = new JLabel(b);
        add(bg);

        JMenuBar mb = new JMenuBar();
        setJMenuBar(mb);

        JMenu master = new JMenu("Master");
        master.setForeground(Color.blue);

        JMenuItem t1 = new JMenuItem("New Employee");
        t1.setFont(new Font("monospaced", Font.PLAIN, 15));
        t1.setMnemonic('N');
        t1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.SHIFT_MASK));
        t1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));

        JMenuItem t2 = new JMenuItem("Salary");
        t2.setFont(new Font("monospaced", Font.PLAIN, 15));
        t2.setMnemonic('S');
        t2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
        t2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/salary.png")));

        JMenuItem t3 = new JMenuItem("List Employees");
        t3.setFont(new Font("monospaced", Font.PLAIN, 15));
        t3.setMnemonic('L');
        t3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.SHIFT_MASK));
        t3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/CUSTOMER.png")));

        master.add(t1);
        master.add(t2);
        master.add(t3);
        mb.add(master);

        t1.addActionListener(this);
        t2.addActionListener(this);
        t3.addActionListener(this);

        //******************************************************************************************************************
        JMenu update = new JMenu("Update");
        update.setForeground(Color.blue);
        mb.add(update);

        JMenuItem up1 = new JMenuItem("Update Salary");
        up1.setFont(new Font("monospaced", Font.PLAIN, 15));
        up1.setMnemonic('S');
        up1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.SHIFT_MASK));
        up1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/emps.png")));
        update.add(up1);
        up1.addActionListener(this);

        JMenuItem up2 = new JMenuItem("Update Employee");
        up2.setFont(new Font("monospaced", Font.PLAIN, 15));
        up2.setMnemonic('E');
        up2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.SHIFT_MASK));
        up2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/users.png")));
        update.add(up2);
        up2.addActionListener(this);

        JMenuItem up3 = new JMenuItem("Take Attendance");
        up3.setFont(new Font("monospaced", Font.PLAIN, 15));
        up3.setMnemonic('T');
        up3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.SHIFT_MASK));
        up3.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/atten.png")));
        update.add(up3);
        up3.addActionListener(this);

        //******************************************************************************************************************
        JMenu reports = new JMenu("Reports");
        reports.setForeground(Color.blue);
        mb.add(reports);

        JMenuItem rep1 = new JMenuItem("Generate Payslip");
        rep1.setFont(new Font("monospaced", Font.PLAIN, 15));
        rep1.setMnemonic('P');
        rep1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.SHIFT_MASK));
        rep1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/payments.png")));
        rep1.addActionListener(this);
        reports.add(rep1);

        JMenuItem rep2 = new JMenuItem("Attendance List");
        rep2.setFont(new Font("monospaced", Font.PLAIN, 15));
        rep2.setMnemonic('L');
        rep2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.SHIFT_MASK));
        rep2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/atten.png")));
        rep2.addActionListener(this);
        reports.add(rep2);

        //******************************************************************************************************************
        JMenu util = new JMenu("Utilities");
        util.setForeground(Color.blue);
        mb.add(util);

        JMenuItem util1 = new JMenuItem("Notepad");
        util1.setFont(new Font("monospaced", Font.PLAIN, 15));
        util1.setMnemonic('N');
        util1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.SHIFT_MASK));
        util1.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/New.png")));
        util1.addActionListener(this);
        util.add(util1);

        JMenuItem util2 = new JMenuItem("Calculator");
        util2.setFont(new Font("monospaced", Font.PLAIN, 15));
        util2.setMnemonic('C');
        util2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.SHIFT_MASK));
        util2.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/calc.png")));
        util2.addActionListener(this);
        util.add(util2);

        JMenuItem util3 = new JMenuItem("Web Browser");
        util3.setFont(new Font("monospaced", Font.PLAIN, 15));
        util3.setMnemonic('W');
        util3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.SHIFT_MASK));
        ImageIcon u1 = new ImageIcon(ClassLoader.getSystemResource("icon/chrome.png"));
        Image u2 = u1.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT);
        util3.setIcon(new ImageIcon(u2));
        util3.addActionListener(this);
        util.add(util3);

        //******************************************************************************************************************
        JMenu logout = new JMenu("Log Out");
        logout.setForeground(Color.RED);
        mb.add(logout);

        JMenuItem log = new JMenuItem("Log Out");
        log.setForeground(Color.RED);
        log.setFont(new Font("monospaced", Font.PLAIN, 15));
        log.setMnemonic('L');
        log.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.SHIFT_MASK));
        log.setIcon(new ImageIcon(ClassLoader.getSystemResource("icon/exit.png")));
        log.addActionListener(this);
        logout.add(log);

    }

    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        if (msg.equalsIgnoreCase("New Employee")){
            new New_Employee().setVisible(true);
        }else if (msg.equalsIgnoreCase("Salary")){
            new Salary().setVisible(true);
        }else if (msg.equalsIgnoreCase("List Employee")){
            new List_Employee().setVisible(true);
        }else if (msg.equalsIgnoreCase("Update Salary")){
            new Update_Salary().setVisible(true);
        }else if(msg.equalsIgnoreCase("Update Employee")){
            new Update_Employee().setVisible(true);
        }else if (msg.equalsIgnoreCase("Take Attendance")){
            new Take_Attendance().setVisible(true);
        }else if (msg.equalsIgnoreCase("Generate Payslip")){
            new Generate_Payslip().setVisible(true);
        }else if (msg.equalsIgnoreCase("Attendance List")){
            new Attendance_List().setVisible(true);
        }else if(msg.equalsIgnoreCase("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception e){e.printStackTrace();}
        }else if (msg.equalsIgnoreCase("Calculator")){
            try{
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception e){e.printStackTrace();}
        }else if (msg.equalsIgnoreCase("Web Browser")){
            try {
                Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
            }catch (Exception e){e.printStackTrace();}
        }else if (msg.equalsIgnoreCase("Log Out")){
            this.setVisible(false);
            new login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Project().setVisible(true);
    }
}
