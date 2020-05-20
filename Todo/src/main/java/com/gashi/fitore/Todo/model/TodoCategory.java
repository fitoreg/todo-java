package com.gashi.fitore.Todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class TodoCategory {

    enum Category {
        PERSONAL,
        WORK,
        SHOPPING,
        COOKING,
        SPORTS
    }

    private Category category;

    // Getters & Setters
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
