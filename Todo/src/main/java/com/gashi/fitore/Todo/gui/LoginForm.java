package com.gashi.fitore.Todo.gui;

import com.gashi.fitore.Todo.helper.HTTPClient;
import com.gashi.fitore.Todo.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm {
    private JLabel lblTitle;
    private JLabel lblEmail;
    private JTextField txtFieldEmail;
    private JLabel lblPassword;
    private JPasswordField txtFieldPassword;
    private JPanel contentView;
    private JButton btnLogin;
    private JButton btnSignUp;

    public LoginForm() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtFieldEmail.getText().isEmpty() || txtFieldPassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(contentView, "Please fill all fields!");
                } else {
                    User loggedInUser = HTTPClient.loginWithCredentials(txtFieldEmail.getText(), txtFieldPassword.getPassword().toString());
                    JOptionPane.showMessageDialog(contentView, "User: " + loggedInUser.getEmail());
                }
            }
        });
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtFieldEmail.getText().isEmpty() || txtFieldPassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(contentView, "Please fill all fields!");
                } else {
                    User registeredUser = HTTPClient.registerUserWithCredentials(txtFieldEmail.getText(), txtFieldPassword.getPassword().toString());
                    JOptionPane.showMessageDialog(contentView, "User: " + registeredUser.getEmail());
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("LoginForm");
        frame.setContentPane(new LoginForm().contentView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


