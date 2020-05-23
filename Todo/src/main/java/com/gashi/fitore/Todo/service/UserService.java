package com.gashi.fitore.Todo.service;

import com.gashi.fitore.Todo.helper.UserAlreadyExistException;
import com.gashi.fitore.Todo.interfaces.IUserService;
import com.gashi.fitore.Todo.model.User;
import com.gashi.fitore.Todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository repository;

    @Transactional
    @Override
    public User registerNewUserAccount(User user) throws UserAlreadyExistException {
        if (emailExist(user.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email address: " +  user.getEmail());
        }

        User newUser = new User();
        newUser.setPassword(user.getPassword());
        newUser.setEmail(user.getEmail());

        return repository.save(user);
    }

    private boolean emailExist(String email) {
        return repository.findUserByEmail(email) != null;
    }
}