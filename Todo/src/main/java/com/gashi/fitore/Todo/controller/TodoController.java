package com.gashi.fitore.Todo.controller;

import com.gashi.fitore.Todo.model.TodoItem;
import com.gashi.fitore.Todo.repository.TodoItemRepository;
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
@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoItemRepository todoRepository;

    // Declare GET Method to list all TodoItems
    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    // Declare POST Method for TodoItem creation
    @PostMapping
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    // Declare PUT Method for TodoItem updates
    @PutMapping TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    // Declare DELETE Method to delete by Id
    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}
