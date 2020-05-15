package com.gashi.fitore.Todo.repository;

import com.gashi.fitore.Todo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

// This class extends the JpaRepository that is responsible for storing
// and retrieving data from the H2 Database.
public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {
}