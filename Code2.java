package dbmsproject;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;  

public class actualpage {
	public static void main(String[] args)
	{
		JFrame f1 = new JFrame();
		f1.setResizable(false);
		f1.getContentPane().setBackground(new Color(123, 50, 250));

		JButton jb1 = new JButton("BILLING");
		jb1.setBounds(10, 10, 180, 30);
		jb1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
                b1.main(new String[0]); 
            }
        });

		JButton jb2 = new JButton("ADD CUSTOMER");
		jb2.setBounds(200, 10, 180, 30);
		jb2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 
                addc.main(new String[0]); 
            }
        });

		JButton jb3 = new JButton("DELETE CUSTOMER");
		jb3.setBounds(390, 10, 180, 30);
		jb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                delc.main(new String[0]); 
            }
        });

		JButton jb4 = new JButton("CUSTOMER DETAILS");
		jb4.setBounds(580, 10, 180, 30);
		jb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                cdetails.main(new String[0]); 
            }
        });

		JButton jb5 = new JButton("UPD_CUST_DET");
		jb5.setBounds(770, 10, 180, 30);
		jb5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                updatecust.main(new String[0]); 
            }
        });

		JButton jb6 = new JButton("ADD CASHIER");
		jb6.setBounds(960, 10, 180, 30);
		jb6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                addcashier.main(new String[0]); 
            }
        });

		JButton jb7 = new JButton("DELETE CASHIER");
		jb7.setBounds(1150, 10, 180, 30);
		jb7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                delcashier.main(new String[0]); 
            }
        });

		JButton jb8 = new JButton("CASHIER DETAILS");
		jb8.setBounds(10, 60, 180, 30);
		jb8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                viewcashdet.main(new String[0]); 
            }
        });

		JButton jb9 = new JButton("UPD_CASH_DET");
		jb9.setBounds(200, 60, 180, 30);
		jb9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                updatecashier.main(new String[0]); 
            }
        });

		JButton jb10 = new JButton("LOGOUT");
		jb10.setBounds(1200, 720, 180, 30);
		jb10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f1.dispose(); 
                login.main(new String[0]); 
            }
        });
		
		 JTextArea tx=new JTextArea();
		    Font font = new Font("Segoe Script", Font.BOLD, 20);
		    tx.setBounds(50,350, 200,50); 
		    tx.setBackground(Color.green); 
		    tx.setForeground(Color.BLUE);
		    tx.setFont(font);

		 

		f1.add(jb1);
		f1.add(jb2);
		f1.add(jb3);
		f1.add(jb4);
		f1.add(jb5);
		f1.add(jb6);
		f1.add(jb7);
		f1.add(jb8);
		f1.add(jb9);
		f1.add(jb10);
		f1.add(tx);
		

		f1.setVisible(true);
		f1.setSize(1400, 800); 
		f1.setLayout(null);
		f1.setLocationRelativeTo(null);

	}

}
