package io.github.ndimovt.validators;

import io.github.ndimovt.validator.IValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameValidator implements IValidator {
    private static final String PATTERN = "^([a-zA-Z]+( [a-zA-Z]+){0,4})$";
    @Override
    public boolean isValid(String input) {
        if(input == null || input.isEmpty()){
            return false;
        }
        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}
