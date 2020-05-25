package com.gashi.fitore.Todo.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TodoItemTableModel extends AbstractTableModel {

    private List<TodoItem> todoItemList;

    public TodoItemTableModel(List<TodoItem> todoItemList) {
        this.todoItemList = new ArrayList<TodoItem>(todoItemList);
    }

    @Override
    public int getRowCount() {
        return todoItemList.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "id";
            case 1:
                return "Title";
            case 2:
                return "Completed";
            default:
                return "";
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object value = "??";
        TodoItem todoItem = todoItemList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = todoItem.getId();
                break;
            case 1:
                value = todoItem.getTitle();
                break;
            case 2:
                value = todoItem.isDone();
                break;
        }
        return value;
    }



    /* Override this if you want the values to be editable...
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        //....
    }
    */

    /**
     * This will return the user at the specified row...
     * @param row
     * @return
     */
    public TodoItem getTodoItemAt(int row) {
        return todoItemList.get(row);
    }
}
