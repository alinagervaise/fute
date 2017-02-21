/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.web.controller;


import com.lecaddyfute.model.entities.Customer;
import com.lecaddyfute.model.entities.Role;
import com.lecaddyfute.model.entities.Shop;
import com.lecaddyfute.model.validators.UsersValidator;
import com.lecaddyfute.model.entities.Users;
import javax.servlet.http.HttpServletRequest;
import com.lecaddyfute.service.DefaultService;
import com.lecaddyfute.service.security.UserService;
import com.lecaddyfute.service.security.AdminService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletException;
/**
 *
 * @author Gervaise Alina
 */
@Controller
public class InitControler {

    @Autowired
    UserService userservice;
    
    @Autowired
    AdminService adminservice;

    @Autowired
    DefaultService service;

    @RequestMapping(value = "/email-comfirmation")
    public String accountActivated(HttpSession session, HttpServletRequest request) {
        String id = request.getParameter("id");
        Users user = userservice.getUserById(id);
        user.setIsActive(1);
        user.setDateActivation(new Date(System.currentTimeMillis()));
        userservice.update(user);
        session.setAttribute("firstname", user.getFirstname());
        return "user_activation_success";
      
    } 
    @RequestMapping(value = {"/connect"}, method = RequestMethod.GET)
    public String signIn(Model model) {
        Users user = new Users();
        model.addAttribute("user", user);
        return "login";
    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public String logOut(Model model, HttpServletRequest request, HttpSession session) {
        try{
            Users user = new Users();
            model.addAttribute("user", user);
            request.getSession().invalidate();
            request.logout();
            return "index";
        }
        catch(ServletException ex){
            ex.printStackTrace();
        }
        return "";
    }
    @RequestMapping(value = {"/login"}, method = RequestMethod.POST)
    public String signInSubmit(@ModelAttribute("user")Users user,
			BindingResult result, Model model, HttpSession session) {
        Users foundUser = userservice.getUserbyUsername(user.getUsername());
        if (foundUser == null || !foundUser.getPassword().equals(user.getPassword())){
            model.addAttribute("user", user);
            result.rejectValue("password", "signin.error");
            model.addAttribute("errorMessage", "signin.error");
            return "login";
        }
        model.addAttribute("user", foundUser);
        session.setAttribute("username", foundUser);
        session.setAttribute("type_account", foundUser.getRole().getId());
        session.setAttribute("username", foundUser.getUsername());
        session.setAttribute("firstname", foundUser.getFirstname());
        return "redirect:authentication_success";
    }
    @RequestMapping(value = {"/authentication_success"})
    public String signInSucess(HttpSession session, Model model) {
        int type_account =  Integer.parseInt(session.getAttribute("type_account").toString());
        model.addAttribute("visitor_count", userservice.getVisitorsCount());
        switch(type_account){
            case 1:
                return "admin/index";
            case 2:
                return "customer/index";
            case 3:
                return "business/index";
            default:
                return "index";
        }
        
    }
    @RequestMapping(value = {"/signup"}, method = RequestMethod.GET)
    public String signup(Model model) {
        Users user = new Users();
        user.setRole(userservice.getRolebyName("ROLE_USER"));
        model.addAttribute("user", user);
        return "signup";
    }

    @RequestMapping(value = {"/signup"}, method = RequestMethod.POST)
    public String signupPost(@Validated @ModelAttribute("user")Users user,
			BindingResult result, HttpServletRequest request, Model model) {
        UsersValidator validator = new UsersValidator();
        validator.validate(user, result); 
           // Validate username
        if (userservice.getUserbyUsername(user.getUsername()) != null){
            result.rejectValue("username", "username.exist.error",
                     "Username already exist.Please enter another one");  
        }
        model.addAttribute("user", user);
        if(result.hasErrors()) {
            
            return "signup";
        }
        user.setDateCreation( new Date(System.currentTimeMillis()));
       
        userservice.create(user);
        Integer type_account =  user.getRole().getId();
        request.setAttribute("type_account",type_account);
        request.setAttribute("username", user.getUsername());
        request.setAttribute("emailTo", user.getEmail());
        request.setAttribute("id", user.getId());
        userservice.sendUserSignUpConfirmation(request);
        
        if (type_account == 2 ){
             Customer customer = new Customer();
             customer.setId(user.getId());
             userservice.create(customer);
            return "customer/signup_confirmation_customer_";
        }
        Shop shop = new Shop();
        shop.setId(user.getId());
        userservice.create(shop);
        return "business/signup_confirmation_business_";
        
    }
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String home(@RequestParam(value = "message", required = false) String message,
            Model model, HttpSession session,HttpServletRequest request) {
        return this.home_(message, model, session,request);
        //return "index";
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String home_(@RequestParam(value = "message", required = false) String message,
            Model model, HttpSession session, HttpServletRequest request) {
        session.setAttribute("lang", request.getLocale().getLanguage());
        userservice.countSession(session);
        Users user = new Users();
        model.addAttribute("user", user);
        model.addAttribute("rayons", adminservice.getRayons());
        model.addAttribute("categories", adminservice.getCategories());
        request.setAttribute("user", user);
        session.setAttribute("position", userservice.getLocalization(request));
        return "index";
    }

    

}
