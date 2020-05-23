package com.gashi.fitore.Todo.helper;

import com.gashi.fitore.Todo.interfaces.PasswordMatches;
import com.gashi.fitore.Todo.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        User user = (User) obj;
        return user.getPassword().equals(user.getPasswordConfirm());
    }
}
