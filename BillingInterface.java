package dbmsproject;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class b2 {
    private static JTextField idTextField;
    private static JTextField nameTextField;
    private static JTextField phoneTextField;
    private static JTextField finalCostTextField; 

    public static void main(String[] args) {
        JFrame f = new JFrame("LOGIN");
        f.setResizable(false);
        f.getContentPane().setBackground(new Color(135, 206, 250));

        JLabel customerDetailsLabel = new JLabel("CUSTOMER DETAILS");
        customerDetailsLabel.setBounds(20, 20, 150, 25);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBounds(20, 60, 80, 25);
        idTextField = new JTextField();
        idTextField.setBounds(100, 60, 150, 25);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(280, 60, 80, 25);
        nameTextField = new JTextField();
        nameTextField.setBounds(360, 60, 150, 25);

        JLabel phoneLabel = new JLabel("PHONE NO:");
        phoneLabel.setBounds(540, 60, 80, 25);
        phoneTextField = new JTextField();
        phoneTextField.setBounds(640, 60, 150, 25);

        JButton fetchButton = new JButton("Fetch");
        fetchButton.setBounds(800, 60, 80, 25);
        fetchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String id = idTextField.getText();
                try {
                    Connection con = DriverManager.getConnection("", "", "");
                    PreparedStatement pst = con.prepareStatement("SELECT * FROM customer WHERE id = ?");
                    pst.setString(1, id);
                    ResultSet rs = pst.executeQuery();
                    if (rs.next()) {
                    	nameTextField.setText(rs.getString("name"));
                    	phoneTextField .setText(rs.getString("phoneNo"));
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No customer found with ID: " + id);
                    }
                    con.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });

        JLabel billingDetailsLabel = new JLabel("BILLING DETAILS");
        billingDetailsLabel.setBounds(20, 100, 150, 25);

        JLabel itemLabel = new JLabel("ITEM:");
        itemLabel.setBounds(20, 140, 80, 25);
        JTextField itemTextField = new JTextField();
        itemTextField.setBounds(100, 140, 150, 25);

        JLabel priceLabel = new JLabel("PRICE:");
        priceLabel.setBounds(280, 140, 80, 25);
        JTextField priceTextField = new JTextField();
        priceTextField.setBounds(360, 140, 150, 25);

        JLabel quantityLabel = new JLabel("QUANTITY:");
        quantityLabel.setBounds(540, 140, 80, 25);
        JTextField quantityTextField = new JTextField();
        quantityTextField.setBounds(640, 140, 150, 25);

        JButton addButton = new JButton("ADD");
        addButton.setBounds(800, 140, 100, 25);

        String[] columnNames = {"Item", "Price", "Quantity", "Total"};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(columnNames);
        JTable table = new JTable();
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 180, 880, 400);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String item = itemTextField.getText();
                double price = Double.parseDouble(priceTextField.getText());
                int quantity = Integer.parseInt(quantityTextField.getText());
                double total = price * quantity;
                model.addRow(new Object[]{item, price, quantity, total});

                itemTextField.setText("");
                priceTextField.setText("");
                quantityTextField.setText("");
            }
        });

        

        JButton jb3 = new JButton("UPDATE");
        jb3.setBounds(700, 600, 100, 25);
        jb3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double finalCost = Double.parseDouble(finalCostTextField.getText());
                    String id = idTextField.getText();
                    
                    // Establish connection
                    Connection con = DriverManager.getConnection("", "", "");
                    
                    // Fetch the current balance from the database
                    PreparedStatement pst = con.prepareStatement("SELECT balance FROM customer WHERE id = ?");
                    pst.setString(1, id);
                    ResultSet rs = pst.executeQuery();
                    
                    if (rs.next()) {
                        double currentBalance = rs.getDouble("balance");
                        
                        // Update the balance in the database
                        double newBalance = currentBalance + finalCost;
                        PreparedStatement updateStmt = con.prepareStatement("UPDATE customer SET balance = ? WHERE id = ?");
                        updateStmt.setDouble(1, newBalance);
                        updateStmt.setString(2, id);
                        int rowsAffected = updateStmt.executeUpdate();
                        
                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Balance updated successfully.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Failed to update balance.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "No customer found with ID: " + id);
                    }
                    
                    // Close resources
                    rs.close();
                    pst.close();
                    con.close();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid final cost.");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });


        JButton jb4 = new JButton("CLOSE");
        jb4.setBounds(1000, 600, 100, 25);
        jb4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f.dispose();
            }
        });
        
        JButton calculateButton = new JButton("Calculate");
        calculateButton.setBounds(950, 500, 100, 25);
        calculateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calculateFinalCost(model);
            }
        });

        JLabel finalCostLabel = new JLabel("Final Cost:");
        finalCostLabel.setBounds(950, 540, 80, 25);
        finalCostTextField = new JTextField();
        finalCostTextField.setBounds(1040, 540, 150, 25);
        
        JTextArea tx=new JTextArea();
	    Font font = new Font("Segoe Script", Font.BOLD, 20);
	    tx.setBounds(50,350, 200,50); 
	    tx.setBackground(Color.green); 
	    tx.setForeground(Color.BLUE);
	    tx.setFont(font);

        // Adding components to the frame
        f.add(customerDetailsLabel);
        f.add(idLabel);
        f.add(idTextField);
        f.add(nameLabel);
        f.add(nameTextField);
        f.add(phoneLabel);
        f.add(phoneTextField);
        f.add(billingDetailsLabel);
        f.add(itemLabel);
        f.add(itemTextField);
        f.add(priceLabel);
        f.add(priceTextField);
        f.add(quantityLabel);
        f.add(quantityTextField);
        f.add(addButton);
        f.add(scrollPane);
        f.add(fetchButton);
        f.add(finalCostLabel);
        f.add(calculateButton);
        f.add(finalCostTextField); // Add finalCostTextField to the frame
        f.add(jb4);
        f.add(jb3);
        
        f.add(tx);

        f.setVisible(true);
        f.setSize(1300, 750);
        f.setLayout(null);
        f.setLocationRelativeTo(null);
    }


    private static void calculateFinalCost(DefaultTableModel model) {
        double totalCost = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            totalCost += (double) model.getValueAt(i, 3);
        }
        finalCostTextField.setText(String.valueOf(totalCost));
    }
}
