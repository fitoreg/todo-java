package com.gashi.fitore.Todo.gui;

import com.gashi.fitore.Todo.helper.HTTPClient;
import com.gashi.fitore.Todo.model.TodoItem;
import com.gashi.fitore.Todo.model.TodoItemTableModel;
import com.gashi.fitore.Todo.model.User;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class TodoListForm extends JPanel {
    private static JFrame frame;
    private JLabel lblTitle;
    private JTextField txtInput;
    private JButton btnCreateTodo;
    private JTable tblView;
    private JPanel contentView;

    public User currentUser;

    private TodoItem[] items;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public TodoListForm() {


        tblView.setAutoCreateRowSorter(true);
        tblView.setFillsViewportHeight(true);
        tblView.setPreferredScrollableViewportSize(new Dimension(550, 200));

        items = HTTPClient.getAllTodoItems((long) 1);
        TodoItemTableModel tiModel = new TodoItemTableModel(Arrays.asList(items));


        for (TodoItem item : items) {
            System.out.println("Title: " + item.getTitle());

        }

        tblView.setModel(tiModel);

        btnCreateTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                TodoItem todoItem = new TodoItem();
                todoItem.setUserId((long) 1);
                todoItem.setTitle(txtInput.getText());
                HTTPClient.postTodoItem(todoItem);

            }
        });
    }

    public static void main(String[] args) {
        frame = new JFrame("TodoListForm");
        frame.setContentPane(new TodoListForm().contentView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
