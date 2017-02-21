/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.model.validators;

import com.lecaddyfute.model.entities.Shop;
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
public class ShopValidator implements Validator  {
    
    
     
    Pattern pattern = null;
    Matcher matcher = null;
    @Override
    public boolean supports(Class<?> type) {
        return Users.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name",
			"name.required", "Champ obligatoire");
   
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "street",
			"street.required", "Champ obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "city",
			"city.required", "Champ obligatoire");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country",
			"country.required", "Champ obligatoire");
   
    }
    
}
