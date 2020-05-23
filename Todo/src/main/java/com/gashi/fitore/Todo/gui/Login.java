package com.gashi.fitore.Todo.gui;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Login {
    private JPanel loginView;
    private JLabel titleLabel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JButton signUpButton;

    public Login() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setSize(1024, 768);
        frame.setContentPane(new Login().loginView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}


