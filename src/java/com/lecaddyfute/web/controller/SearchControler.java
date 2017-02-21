/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.web.controller;


import com.lecaddyfute.model.entities.City;
import com.lecaddyfute.model.entities.Customer;
import com.lecaddyfute.model.entities.Neighborhood;
import com.lecaddyfute.model.entities.Product;
import com.lecaddyfute.model.entities.Role;
import com.lecaddyfute.model.entities.Shop;
import com.lecaddyfute.model.validators.UsersValidator;
import com.lecaddyfute.model.entities.Users;
import javax.servlet.http.HttpServletRequest;
import com.lecaddyfute.service.DefaultService;
import com.lecaddyfute.service.security.UserService;
import com.lecaddyfute.service.security.AdminService;
import com.lecaddyfute.service.security.SearchService;
import java.util.ArrayList;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author Gervaise Alina
 */
@Controller
public class SearchControler {

    @Autowired
    SearchService searchservice;
    
 
    @RequestMapping(value = {"/search/locations"},  method = RequestMethod.GET)
    public  @ResponseBody JSONObject getLocation(@RequestParam("lterm") String term,
              Model model, HttpSession session) {
        
        //System.out.println("SEARCHCONTROLER"+ term);
        JSONObject json = new JSONObject();
        List<City> cities;
        List<Neighborhood> neighborhoods;
        try{
            int zipCode = Integer.parseInt(term);
            //search by zipcode
            cities = searchservice.getCity(zipCode);
        }
        catch(NumberFormatException ex){
            //value enter is not a number search for other critera
            //json.put("category", product.getCategory().getName());
            cities = searchservice.getCity(term);
        }
//        if (!cities.isEmpty()){
//            for(City c: cities){
//                json.put(c.getId(), c.getName());
//            }
//        }
//        
//        neighborhoods  = searchservice.getNeighborhood(term);
//        if (!neighborhoods.isEmpty()){
//            for(Neighborhood n: neighborhoods){
//                json.put(n.getId(), n.getName());
//            }
//        }
        List<Neighborhood>locations = searchservice.getLocation(term);
        for (Neighborhood l : locations){
            //System.out.println("SEARCHCONTROLER"+l);
            Map m = new HashMap();
            m.put("name", l.getName());
            m.put("city", l.getCity().getName());
            m.put("Zipcode", l.getCity().getZipCode());
            json.put(l.getId(), m);
        }
        System.out.println("SEARCHCONTROLER"+json);
        return json;
       
    }
  
}
