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
    private JTextField txtEditID;
    private JTextField txtEditTODO;
    private JButton btnEdit;
    private JTextField txtDeleteID;
    private JButton btnDelete;
    private JButton btnDone;

    private User currentUser;


    private TodoItem[] items;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }


    public TodoListForm(User currentUser) {
        this.currentUser = currentUser;
        updateTableView();

        btnCreateTodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TodoItem todoItem = new TodoItem();
                todoItem.setUserId(currentUser.getId());
                todoItem.setTitle(txtInput.getText());
                HTTPClient.postTodoItem(todoItem);
                updateTableView();
            }
        });
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtEditID.getText().isEmpty() && !txtEditTODO.getText().isEmpty()) {
                    TodoItem itemToEdit = new TodoItem();
                    itemToEdit.setId(Long.valueOf(txtEditID.getText()));
                    itemToEdit.setUserId(currentUser.getId());
                    itemToEdit.setTitle(txtEditTODO.getText());
                    boolean success = HTTPClient.editTodoItem(itemToEdit);
                    if (success) {
                        updateTableView();
                        JOptionPane.showMessageDialog(contentView, "Item was edited successfully!");
                    } else  {
                        JOptionPane.showMessageDialog(contentView, "There was an error editing the item.");
                    }
                }
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!txtDeleteID.getText().isEmpty()) {
                    boolean success = HTTPClient.deleteTodoItem(txtDeleteID.getText());
                    if (success) {
                        updateTableView();
                        JOptionPane.showMessageDialog(contentView, "Item was deleted successfully!");
                    }
                }
            }
        });
    }

    public void updateTableView() {
        tblView.setAutoCreateRowSorter(true);
        tblView.setFillsViewportHeight(true);
        tblView.setPreferredScrollableViewportSize(new Dimension(550, 500));
        items = HTTPClient.getAllTodoItems(this.currentUser.getId());
        TodoItemTableModel tiModel = new TodoItemTableModel(Arrays.asList(items));
        tblView.setModel(tiModel);
    }

    public void setup() {
        frame = new JFrame("TodoListForm");
        frame.setContentPane(new TodoListForm(this.currentUser).contentView);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
