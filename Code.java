package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;

public class login {
    public static void main(String[] args) {
        JFrame f = new JFrame("LOGIN"); 
        f.setResizable(false);
        f.getContentPane().setBackground(new Color(123, 50, 250));

        JLabel l1 = new JLabel("USERID");
        l1.setBounds(50, 60, 80, 25);
        JTextField t1 = new JTextField();  
        t1.setBounds(150, 60, 80, 25); 

        JLabel l2 = new JLabel("PASSWORD");
        l2.setBounds(50, 90, 80, 25);
        JPasswordField t2 = new JPasswordField();  
        t2.setBounds(150, 90, 80, 25); 

        JButton jb = new JButton("LOGIN");
        jb.setBounds(100, 150, 100, 20);
        jb.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                String id = t1.getText();
                String password = new String(t2.getPassword());
                if (validateLogin(id, password)) {
                    f.dispose();
                    actualpage.main(new String[0]);
                } else {
                    JOptionPane.showMessageDialog(null, "WRONG CREDENTIALS", "LOGIN ERROR", JOptionPane.PLAIN_MESSAGE);
                }
            }  
        }); 

        JButton jb1 = new JButton("CLOSE");
        jb1.setBounds(210, 150, 100, 20); 
        jb1.addActionListener(new ActionListener() {  
            public void actionPerformed(ActionEvent e) {  
                f.dispose();
            }  
        });

        JTextArea tx = new JTextArea();
        Font font = new Font("Segoe Script", Font.BOLD, 20);
        tx.setBounds(50, 450, 200, 50); 
        tx.setBackground(Color.green); 
        tx.setForeground(Color.BLUE);
        tx.setFont(font);

        f.add(l1);
        f.add(l2);
        f.add(t1);
        f.add(t2);
        f.add(jb);
        f.add(jb1);
        f.add(tx);

        f.setVisible(true);
        f.setSize(400, 300);
        f.setLayout(null); 
        f.setLocationRelativeTo(null);
    }

    private static boolean validateLogin(String id, String password) {
        try {
            Connection con = DriverManager.getConnection("", "", "");
            PreparedStatement pst = con.prepareStatement("SELECT * FROM cashier WHERE id = ? AND password = ?");
            pst.setString(1, id);
            pst.setString(2, password);
            ResultSet rs = pst.executeQuery();
            boolean isValid = rs.next();
            con.close();
            return isValid;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
