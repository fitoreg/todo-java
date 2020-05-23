package com.gashi.fitore.Todo.helper;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
