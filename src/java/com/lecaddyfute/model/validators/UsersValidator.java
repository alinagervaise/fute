/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.model.validators;

import com.lecaddyfute.model.entities.Users;
import com.lecaddyfute.service.security.UserService;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Z
 */
public class UsersValidator implements Validator  {
    
    
     
    Pattern pattern = null;
    Matcher matcher = null;
    @Override
    public boolean supports(Class<?> type) {
        return Users.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username",
			"username.required", "Champ obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname",
			"firstname.required", "Champ obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname",
			"last.required", "Champ obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email",
			"email.required", "Champ obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
			"password.required", "Champ obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passwordConfirmed",
			"passwordConfirmed.required", "Champ obligatoire");
        Users user = (Users) o;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        if (user.getEmail() != null && !user.getEmail().isEmpty()) {  
            pattern = Pattern.compile(EMAIL_PATTERN);  
            matcher = pattern.matcher(user.getEmail());  
            if (!matcher.matches()) {  
                errors.rejectValue("email", "email.pattern.error",  "Enter a correct email");  
            }  
        }
     
         // Validate password
        String password = user.getPassword();
        if (password.length() < 8){
            errors.rejectValue("password", "password.size.error", 
                    "Mot de passe doit avoir au moins 8 caracteres");
        }
        if (!user.getPassword().equals(user.getPasswordConfirmed())){
            errors.rejectValue("passwordConfirmed", "password.confirmation.error");
        }
   
    }
    
}
