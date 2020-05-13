package com.gashi.fitore.Todo.controller;

import com.gashi.fitore.Todo.model.TodoItem;
import com.gashi.fitore.Todo.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")

@RestController

@RequestMapping(value = "/todo")
public class TodoController {

    @Autowired
    private TodoItemRepository todoRepository;

    @GetMapping
    public List<TodoItem> findAll() {
        return todoRepository.findAll();
    }

    @PostMapping
    public TodoItem save(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    @PutMapping TodoItem update(@Valid @NotNull @RequestBody TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        todoRepository.deleteById(id);
    }
}
