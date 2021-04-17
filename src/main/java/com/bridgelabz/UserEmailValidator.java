package com.bridgelabz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserEmailValidator {
    private final String EMAIL_PATTERN = "^[a-z]+[-.+]{0,1}[0-9]*@[a-z0-9]+[.]{1}(com|net)[.,]{0,1}[a-z{2}]*$";

    public boolean validateEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        boolean result = ((Matcher) matcher).matches();
        return result;
    }
}
