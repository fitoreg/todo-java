package com.gashi.fitore.Todo.controller;

import com.gashi.fitore.Todo.helper.UserAlreadyExistException;
import com.gashi.fitore.Todo.interfaces.IUserService;
import com.gashi.fitore.Todo.model.TodoItem;
import com.gashi.fitore.Todo.model.User;
import com.gashi.fitore.Todo.repository.TodoItemRepository;
import com.gashi.fitore.Todo.repository.UserRepository;
import com.gashi.fitore.Todo.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

// This header allows us to run the API on multiple browsers
@CrossOrigin(origins = "*", allowedHeaders = "*")

// This Spring annotation declares the TodoConroller class as a REST Controller
@RestController

// Define the end-point path
@RequestMapping(value = "/todo/user")
public class UserController {

    private final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private IUserService userService;

    // Declare GET Method to list all TodoItems
    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping
    public User registerUserAccount(@Valid @NotNull @RequestBody User user) throws UserAlreadyExistException {
        User registered = userService.registerNewUserAccount(user);
        return registered;
    }
}
