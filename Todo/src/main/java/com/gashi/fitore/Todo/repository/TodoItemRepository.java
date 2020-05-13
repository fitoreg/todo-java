package com.gashi.fitore.Todo.repository;

import com.gashi.fitore.Todo.model.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, Long> {


}