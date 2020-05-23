package com.gashi.fitore.Todo.helper;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
