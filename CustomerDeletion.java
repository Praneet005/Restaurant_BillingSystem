package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class delc {
    public static void main(String[] args) {
        JFrame f2 = new JFrame();
        f2.setResizable(false);
        f2.getContentPane().setBackground(new Color(135, 206, 250));

        JLabel l1 = new JLabel("ID:");
        l1.setBounds(50, 40, 80, 25);

        JTextField t1 = new JTextField();
        t1.setBounds(150, 80, 200, 25);

        JLabel l2 = new JLabel("NAME:");
        l2.setBounds(50, 80, 80, 25);

        JTextField t2 = new JTextField();
        t2.setBounds(150, 120, 200, 25);

        JLabel l3 = new JLabel("PHONE NO:");
        l3.setBounds(50, 120, 80, 25);

        JTextField t3 = new JTextField();
        t3.setBounds(150, 40, 100, 25);

        JButton jb1 = new JButton("DELETE");
        jb1.setBounds(50, 260, 180, 30);
        jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the ID from the text field
                String id = t3.getText();
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "Saibunty@1");
                    PreparedStatement pst = con.prepareStatement("DELETE FROM customer WHERE id = ?");
                    pst.setString(1, id);
                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Customer deleted successfully.");
                        // Clear text fields after deletion
                        t1.setText("");
                        t2.setText("");
                        t3.setText("");
                    } else {
                        JOptionPane.showMessageDialog(null, "No customer found with ID: " + id);
                    }
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JButton jb2 = new JButton("CLOSE");
        jb2.setBounds(250, 260, 180, 30);
        jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f2.dispose();
            }
        });

        JButton jb3 = new JButton("SEARCH");
        jb3.setBounds(360, 40, 100, 25);
        jb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Get the ID from the text field
                String id = t3.getText();
                try {
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bms", "root", "Saibunty@1");
                    PreparedStatement pst = con.prepareStatement("SELECT name, phoneNo FROM customer WHERE id = ?");
                    pst.setString(1, id);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                        // Display customer details in text fields
                        t1.setText(rs.getString("name"));
                        t2.setText(rs.getString("phoneNo"));
                    } else {
                        JOptionPane.showMessageDialog(null, "No customer found with ID: " + id);
                    }
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JTextArea tx = new JTextArea();
        Font font = new Font("Segoe Script", Font.BOLD, 20);
        tx.setBounds(50, 350, 200, 50);
        tx.setBackground(Color.green);
        tx.setForeground(Color.BLUE);
        tx.setFont(font);

        f2.add(l3);
        f2.add(l2);
        f2.add(l1);
        f2.add(jb2);
        f2.add(jb1);
        f2.add(jb3);
        f2.add(t2);
        f2.add(t1);
        f2.add(t3);
        f2.add(tx);

        f2.setVisible(true);
        f2.setSize(500, 400);
        f2.setLayout(null);
        f2.setLocationRelativeTo(null);
    }
}
