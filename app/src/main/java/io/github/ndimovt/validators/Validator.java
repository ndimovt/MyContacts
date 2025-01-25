package io.github.ndimovt.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    private static final String PHONE_NUM_PATTERN = "^0[89][0-9]{8}$";
    private static final String NAME_PATTERN = "^([a-zA-Z]+( [a-zA-Z]+){0,4})$";

    public static boolean nameValidator(String name){
        if(name == null || name.isEmpty()){
            return false;
        }
        Pattern pattern = Pattern.compile(NAME_PATTERN);
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
    public static boolean phoneNumberValidator(String phoneNumber){
        if(phoneNumber == null || phoneNumber.isEmpty()){
            return false;
        }
        Pattern pattern = Pattern.compile(PHONE_NUM_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean emailValidator(String email){
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
}
