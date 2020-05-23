package com.gashi.fitore.Todo.controller;

import com.gashi.fitore.Todo.model.TodoItem;
import com.gashi.fitore.Todo.model.User;
import com.gashi.fitore.Todo.repository.TodoItemRepository;
import com.gashi.fitore.Todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UserRepository userRepository;

    // Declare GET Method to list all TodoItems
    @GetMapping
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @PostMapping
    public User registerUserAccount(@Valid @NotNull @RequestBody User user) {
        return userRepository.save(user);
    }
}
