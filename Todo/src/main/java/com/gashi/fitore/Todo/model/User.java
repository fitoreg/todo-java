package com.gashi.fitore.Todo.model;

import com.gashi.fitore.Todo.interfaces.PasswordMatches;
import com.gashi.fitore.Todo.interfaces.ValidEmail;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "user")
@PasswordMatches
public class User implements Serializable {

    private Long id;

    @NotNull
    @NotEmpty
    @ValidEmail
    private String email;

    @NotNull
    @NotEmpty
    private char[] password;

    @NotNull
    @NotEmpty
    private char[] passwordConfirm;

    // Empty Constructor
    public User() {
    }

    // Constructor
    public User(Long id, @NotNull @NotEmpty String email, char[] password, char[] passwordConfirm) {
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

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    @Transient
    public char[] getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(char[] passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
}
