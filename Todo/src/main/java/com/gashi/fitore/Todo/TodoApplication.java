package com.gashi.fitore.Todo;

import com.gashi.fitore.Todo.gui.LoginForm;
import com.gashi.fitore.Todo.helper.UserAlreadyExistException;
import com.gashi.fitore.Todo.model.User;
import com.gashi.fitore.Todo.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication {

	public static void main(String[] args) throws UserAlreadyExistException {
		// Run the REST API
		SpringApplication.run(TodoApplication.class, args);
	}

}
