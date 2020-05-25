package com.gashi.fitore.Todo.gui;

import com.gashi.fitore.Todo.helper.HTTPClient;
import com.gashi.fitore.Todo.model.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JPanel {
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
                    String decryptedPassword = "";
                    for(char x : txtFieldPassword.getPassword()) {
                        decryptedPassword += x;
                    }
                    User loggedInUser = HTTPClient.loginWithCredentials(txtFieldEmail.getText(), decryptedPassword);
                    JOptionPane.showMessageDialog(contentView, "User: " + loggedInUser.getEmail());

                    JFrame frame = new JFrame("TodoListForm");
                    frame.setVisible(true);
                }
            }
        });
        btnSignUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtFieldEmail.getText().isEmpty() || txtFieldPassword.getPassword().length == 0) {
                    JOptionPane.showMessageDialog(contentView, "Please fill all fields!");
                } else {
                    String decryptedPassword = "";
                    for(char x : txtFieldPassword.getPassword()) {
                        decryptedPassword += x;
                    }

                    User registeredUser = HTTPClient.registerUserWithCredentials(txtFieldEmail.getText(), decryptedPassword);
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


