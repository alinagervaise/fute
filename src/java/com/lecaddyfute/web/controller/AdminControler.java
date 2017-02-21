/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.web.controller;



import com.lecaddyfute.model.entities.Address;
import com.lecaddyfute.model.entities.Category;
import com.lecaddyfute.model.entities.Product;
import com.lecaddyfute.model.entities.PromotedProduct;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.json.simple.JSONObject;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

/**
 *
 * @author Gervaise Alina
 */
@Controller

@RequestMapping(value = "/admin")
public class AdminControler {

    @Autowired
    UserService userservice;
    
    @Autowired
    AdminService adminservice;

    @Autowired
    DefaultService service;

    @Autowired
    private ResourceLoader resourceLoader;

    @RequestMapping(value = {"/index"}, method = RequestMethod.GET)
    public String getDashboard(Model model, HttpSession session) {
        model.addAttribute("visitor_count", userservice.getVisitorsCount());
       
        return "admin/index";
    }
        
    @RequestMapping(value = {"/users"}, method = RequestMethod.GET)
    public String getUsers( Model model) {
        
        model.addAttribute("users", adminservice.getUsers());
        return "admin/users";
    }
    
    @RequestMapping(value = "/save", params = "id", method = RequestMethod.GET)
    public String save(@RequestParam("id") Integer id, Model model) {
        Rayon rayon = (Rayon)adminservice.getById(id, Rayon.class);
        userservice.update(rayon);
        return "redirect:/rayons";
    }
    
    @RequestMapping(value = "/rayon/delete", method = RequestMethod.GET)
    public String remove( HttpServletRequest request, Model uiModel) {
        try{
            Rayon rayon = (Rayon)adminservice.getById(Integer.parseInt(request.getParameter("id"))
                                            , Rayon.class);
            adminservice.deleteById(rayon.getId(), Rayon.class);
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/admin/rayons";
    }

    @RequestMapping(value = {"/rayons"}, method = RequestMethod.GET)
    public String getRayons( Model model) {
        model.addAttribute("rayons", adminservice.getRayons());
        return "admin/rayons";
    }
    @RequestMapping(value = {"/rayons/add"}, method = RequestMethod.GET)
    public String getAddRayon( Model model) {
        model.addAttribute("rayon", new Rayon());
        return "admin/rayon_add";
    }
    @RequestMapping(value = {"/rayons"}, method = RequestMethod.POST)
    public String saveRayon(@ModelAttribute("rayon")Rayon rayon,  HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
  
         if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile f: fileUpload){
                String localPath = String.join(File.separator, 
                        request.getRealPath("/") , "WEB-INF", 
                        "resources","uploadedImages");
                File dir = new File(localPath);
                if (!dir.exists()){
                    dir.mkdir();
                }
                File destination = new File(String.join(File.separator, localPath,f.getOriginalFilename()));
                f.transferTo(destination);
                String url = String.join(File.separator, "uploadedImages",f.getOriginalFilename());
             
                rayon.setPath(url);
           
            }
        }
        rayon.setDateCreation( new Date(System.currentTimeMillis()));
        adminservice.create(rayon);
        return "redirect:rayons";
    }  
    
    @RequestMapping(value = {"/categories"}, method = RequestMethod.GET)
    public String getCategories( Model model) {
        model.addAttribute("categories", adminservice.getCategories());
        return "admin/categories";
    }
    @RequestMapping(value = {"/categories/add"}, method = RequestMethod.GET)
    public String getAddCategory( Model model) {
        model.addAttribute("category", new Category());
        model.addAttribute("rayons",adminservice.getRayons());
        return "admin/category_add";
    }
    @RequestMapping(value = {"/categories"}, method = RequestMethod.POST)
    public String saveCategory(@ModelAttribute("category")Category category, 
          
            HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
  
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile f: fileUpload){
                String localPath = String.join(File.separator, 
                        request.getRealPath("/") , "WEB-INF", 
                        "resources","uploadedImages");
                File dir = new File(localPath);
                if (!dir.exists()){
                    dir.mkdir();
                }
                File destination = new File(String.join(File.separator, localPath,f.getOriginalFilename()));
                f.transferTo(destination);
                String url = String.join(File.separator, "uploadedImages",f.getOriginalFilename());
                category.setPath(url);
           
            }
        }
        List<Rayon> rayons = adminservice.getRayonByName(category.getRayon().getName());
        Rayon rayon = rayons.get(0);

        category.setDateCreation( new Date(System.currentTimeMillis()));
        category.setRayon(rayon);
        adminservice.create(category);
      
        return "redirect:categories";
    }  
        
    @RequestMapping(value = {"/products"}, method = RequestMethod.GET)
    public String getProducts( Model model) {
        
        model.addAttribute("products", adminservice.getProducts());
        return "admin/products";
    }
    @RequestMapping(value = {"/products"}, method = RequestMethod.POST)
    public String saveProducts(@ModelAttribute("product")Product product, 
        HttpServletRequest request,
        @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {

        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile f: fileUpload){
                String localPath = String.join(File.separator, 
                        request.getRealPath("/") , "WEB-INF", 
                        "resources","uploadedImages");
                File dir = new File(localPath);
                if (!dir.exists()){
                    dir.mkdir();
                }
                File destination = new File(String.join(File.separator, localPath,f.getOriginalFilename()));
                f.transferTo(destination);
                String url = String.join(File.separator, "uploadedImages",f.getOriginalFilename());
                product.setMainImage(url);
           
            }
        }
        List<Category> categories = adminservice.getCategoryByName(product.getCategory().getName());
        Category category = categories.get(0);

        product.setDateCreation( new Date(System.currentTimeMillis()));
        product.setCategory(category);
        adminservice.create(product);
      
        return "redirect:products";
    } 
    @RequestMapping(value = {"/product/add"}, method = RequestMethod.GET)
    public String getAddProduct( Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories",adminservice.getCategories());
        return "admin/product_add";
    }
    
    @RequestMapping(value = {"/shops"}, method = RequestMethod.GET)
    public String getShops( Model model) {
        
        model.addAttribute("shops", adminservice.getShops());
        return "admin/shops";
    }
    @RequestMapping(value = {"/shop/add"}, method = RequestMethod.GET)
    public String getAddShop( Model model) {
        model.addAttribute("shop", new Shop());
      
        return "admin/shop_add";
    }
    
    @RequestMapping(value = {"/shops"}, method = RequestMethod.POST)
    public String saveShop(@ModelAttribute("shop")Shop shop, 
            BindingResult result,
            HttpServletRequest request,
            @RequestParam CommonsMultipartFile[] fileUpload) throws Exception {
  
        if (fileUpload != null && fileUpload.length > 0) {
            for (CommonsMultipartFile f: fileUpload){
                String localPath = String.join(File.separator, 
                        request.getRealPath("/") , "WEB-INF", 
                        "resources","uploadedImages");
                File dir = new File(localPath);
                if (!dir.exists()){
                    dir.mkdir();
                }
                File destination = new File(String.join(File.separator, localPath,f.getOriginalFilename()));
                f.transferTo(destination);
                String url = String.join(File.separator, "uploadedImages",f.getOriginalFilename());
                shop.setLogo(url);
           
            }
        }
        
        Address newAddress = new Address();
        newAddress.clone(shop.getAddress());
        System.out.println("SAVE SHOP================"+newAddress);
        List<Shop> shops = adminservice.getShopByAddress(shop);
        
      
        if (!shops.isEmpty()){
            result.rejectValue("address.street", "shop.same.address.error",  "This shop has the same address of anothor one.Please modify this entry");
            return "admin/shop_add";
        }
        shop.setDateCreation( new Date(System.currentTimeMillis()));
        adminservice.create(shop);
        
        return "redirect:shops";
    }  
    @RequestMapping(value = "shop/save", params = "id", method = RequestMethod.GET)
    public String saveShop(@RequestParam("id") Integer id,
            @ModelAttribute("shop")Shop shop,  Model model) {
        Shop shopFound = (Shop)adminservice.getById(id, Shop.class);
 
        shopFound.clone(shop);
        System.out.println("SHOPFOUND" + shopFound);
        shopFound.setDateModification( new Date(System.currentTimeMillis()));
        userservice.update(shop);
        return "redirect:shops";
    }
    @RequestMapping(value = "shop/edit", params = "id", method = RequestMethod.GET)
    public String editShop(@RequestParam("id") Integer id, Model model,HttpSession session) {
        Shop shop = (Shop)adminservice.getById(id, Shop.class);
        model.addAttribute("shop", shop);
        session.setAttribute("shopId", shop.getId());
        model.addAttribute("promotedProducts", shop.getPromotedProducts());
        model.addAttribute("promotedProduct", new PromotedProduct());
        model.addAttribute("products", adminservice.getProducts());
        return "admin/shop/shop_edit";
    }
    @RequestMapping(value = "shop/add/product", method = RequestMethod.GET)
    public String addProductToShop(Model model, HttpSession session) {
        Shop shop = (Shop)model.asMap().get("shop");
        model.addAttribute("shop", shop);
        model.addAttribute("promotedProduct", new PromotedProduct());
        model.addAttribute("products", adminservice.getProducts());
        return "admin/shop/shop_add_product";
    }

    @RequestMapping(value = "/shop/product/save",  method = RequestMethod.POST)
    public  String saveShopProduct(
             @ModelAttribute("promotedProduct")PromotedProduct pProduct, 
            Model model,
             HttpServletRequest request,
             HttpSession session){ 
        Integer  productId = (Integer)session.getAttribute("productId");
        Product product = (Product)adminservice.getById(productId, Product.class);
        Shop shop = (Shop)adminservice.getById(session.getAttribute("shopId"),
                Shop.class);
        pProduct.setDateCreation(new Date(System.currentTimeMillis()));
        pProduct.setProduct(product);
        pProduct.setShop(shop);
        adminservice.create(pProduct);
        model.addAttribute("shop", shop);
        model.addAttribute("promotedProducts", adminservice.getPromotedProducts(shop));
        return "admin/shop/shop_edit";
    }
     @RequestMapping(value = "shop/add/product",  method = RequestMethod.POST)
    public  @ResponseBody JSONObject getShopProduct(@RequestParam("id") Integer id,
              Model model, HttpSession session) {
        JSONObject json = new JSONObject();
        Product product = (Product)adminservice.getById(id, Product.class);
        model.addAttribute("product", product);
        json.put("category", product.getCategory().getName());
        json.put("brand", product.getBrand());
        json.put("id", product.getId());
        session.setAttribute("productId", product.getId());
        json.put("description", product.getDescription());
        json.put("designation", product.getDesignation());
        json.put("main_image", product.getMainImage());
        json.put("thumb1_img", product.getImageThum1());
        json.put("thumb2_img", product.getImageThum2());
        json.put("thumb3_img", product.getImageThum3());
        json.put("thumb4_img", product.getImageThum4());
        json.put("quantity", product.getQuantity());
       
        return json;
       
    }
}

