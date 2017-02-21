/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.web.controller;



import com.lecaddyfute.model.entities.Category;
import com.lecaddyfute.model.entities.Product;
import com.lecaddyfute.model.entities.Rayon;
import com.lecaddyfute.model.entities.Shop;
import com.lecaddyfute.model.entities.Users;
import com.lecaddyfute.service.DefaultService;
import com.lecaddyfute.service.security.AdminService;
import com.lecaddyfute.service.security.UserService;
import java.util.Date;
import java.util.logging.Level;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Gervaise Alina
 */
@Controller
@RequestMapping(value = "/admin")
public class ShopControler {

    @Autowired
    UserService userservice;
    
    @Autowired
    AdminService adminservice;

    @Autowired
    DefaultService service;

    @Autowired
    private ResourceLoader resourceLoader;

  
    
}
