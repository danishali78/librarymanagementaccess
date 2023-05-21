/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class GrupMBSE203083BSE203070 extends JFrame {
private JTextField usernameField;
private JPasswordField passwordField;

    public GrupMBSE203083BSE203070() {
        initializeUI();
    }
    private void initializeUI() {
        setTitle("Login");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(50, 30, 80, 25);
        
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(50, 80, 80, 25);
        
        usernameField = new JTextField();
        usernameField.setBounds(50, 50, 120, 25);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(50, 100, 120, 25);
        
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(110, 140, 80, 25);
        
          loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            if (username.equals("manager") && password.equals("123")) {
                JOptionPane.showMessageDialog(panel, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(panel, "Invalid username or password. Please try again.");
            }
        });
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                if (authenticate(username, password)) {
                    openAdminFunctionPage();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(usernameLabel);
        panel.add(usernameField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(new JLabel()); 
        panel.add(loginButton);

        add(panel);
        panel.setLayout(null);
    }

    private boolean authenticate(String username, String password) {
      
        return username.equals("manager") && password.equals("123");
    }

    private void openAdminFunctionPage() {
        AdminFunctionPageGUI adminGUI = new AdminFunctionPageGUI();
        adminGUI.setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
               GrupMBSE203083BSE203070 loginGUI = new GrupMBSE203083BSE203070();
                loginGUI.setVisible(true);
            }
        });
    }
}

class AdminFunctionPageGUI extends JFrame {
private JList<String> bookList;
    private DefaultListModel<String> listModel;
public BiookDoa bookDAO;
public Userrdoa userDAO;
    public AdminFunctionPageGUI() {
        setTitle("Admin Function Page");
        JLabel tf = new JLabel("Admin functions ");
        tf.setBounds(110, 50, 100, 30);
        
        setSize(600, 500);
        JButton bt = new JButton("View book");
        
        bt.setBounds(110, 140, 100, 30);
        bt.setBackground(Color.GRAY);
        JButton bt1 = new JButton("view user");
         
        bt1.setBounds(220, 140, 100, 30);
        bt1.setBackground(Color.GRAY);
        JButton bt2 = new JButton("view issue book");
         
        bt2.setBounds(330, 140, 100, 30);
        bt2.setBackground(Color.GRAY);
         JButton bt3 = new JButton("issue book");
          
        bt3.setBounds(440, 140, 100, 30);
        bt3.setBackground(Color.GRAY);
         JButton bt4 = new JButton("add user");
          
        bt4.setBounds(110, 200, 100, 30);
        bt4.setBackground(Color.GRAY);
        JButton bt5 = new JButton("add book");
         
        bt5.setBounds(220, 200, 100, 30);
        bt5.setBackground(Color.GRAY);
        JButton bt6 = new JButton("return book");
         
        bt6.setBounds(330, 200, 100, 30);
        bt6.setBackground(Color.GRAY);
        JButton bt7 = new JButton("create/reset");
          
        bt7.setBounds(440, 200, 100, 30);
        bt7.setBackground(Color.GRAY);
        setLayout(null);
        add(tf);
        add(bt);
        add(bt1);
        add(bt2);
        add(bt3);
        add(bt4);
        add(bt5);
        add(bt6);
        add(bt7);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
 
    }

    
}
