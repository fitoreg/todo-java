package com.gashi.fitore.Todo.interfaces;

import com.gashi.fitore.Todo.helper.UserAlreadyExistException;
import com.gashi.fitore.Todo.helper.UserNotFoundException;
import com.gashi.fitore.Todo.model.User;

public interface IUserService {
    User registerNewUserAccount(User user) throws UserAlreadyExistException;
    User loginUser(User user) throws UserNotFoundException;
}
