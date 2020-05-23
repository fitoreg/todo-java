package com.gashi.fitore.Todo.repository;

import com.gashi.fitore.Todo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
}
