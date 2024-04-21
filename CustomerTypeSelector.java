package dbmsproject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 
import java.sql.*;

public class b1
{
	public static void main(String[] args) {
	JFrame f = new JFrame("LOGIN"); 
    f.setResizable(false);
    f.getContentPane().setBackground(new Color(135, 206, 250));
    
    JLabel label = new JLabel("IS IT A REGULAR CUSTOMER?");
    label.setBounds(100, 50, 250, 30);
    
    JButton yesButton = new JButton("Yes");
    yesButton.setBounds(100, 100, 100, 30);
    yesButton.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {  
            
            
                f.dispose();
                b2.main(new String[0]);
            
        }  
    });
    
    JButton noButton = new JButton("No");
    noButton.setBounds(220, 100, 100, 30);
    noButton.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent e) {  
            
            
                f.dispose();
                b3.main(new String[0]);
            
        }  
    });
    
    JTextArea tx=new JTextArea();
    Font font = new Font("Segoe Script", Font.BOLD, 20);
    tx.setBounds(50,350, 200,50); 
    tx.setBackground(Color.green); 
    tx.setForeground(Color.BLUE);
    tx.setFont(font);
    
    
    f.add(label);
    f.add(noButton);
    f.add(yesButton);
    f.add(tx);
    
    f.setVisible(true);
    f.setSize(400, 300);
    f.setLayout(null); 
    f.setLocationRelativeTo(null);
    
	}

}
