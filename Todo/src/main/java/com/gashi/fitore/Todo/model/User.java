package com.gashi.fitore.Todo.model;

import com.gashi.fitore.Todo.interfaces.PasswordMatches;
import com.gashi.fitore.Todo.interfaces.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Entity
@Table(name = "user")
@PasswordMatches
public class User {

    private Long id;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private String password;

    @NotNull
    @NotEmpty
    private String passwordConfirm;

    // Empty Constructor
    public User() {
    }

    // Constructor
    public User(Long id, @NotNull @NotEmpty String email, @NotNull @NotEmpty String password, @NotNull @NotEmpty String passwordConfirm) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
    }

    // Getters & Setters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
