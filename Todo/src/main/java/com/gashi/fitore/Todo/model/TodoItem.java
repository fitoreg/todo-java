package com.gashi.fitore.Todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class TodoItem {

    // Properties
    @Id // Primary key
    @GeneratedValue // Generates keys automatically
    private Long id;
    @NotBlank
    private String title;
    private boolean  isDone;


    // Empty Constructor
    public TodoItem() {
    }

    // Constructor
    public TodoItem(Long id, String title, boolean isDone) {

        this.id = id;
        this.title = title;
        this.isDone = isDone;
    }

    // Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setIsDone(boolean done) {
        isDone = done;
    }
}
