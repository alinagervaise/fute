/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.service.security;

import com.lecaddyfute.model.entities.Product;
import com.lecaddyfute.model.entities.Rayon;
import com.lecaddyfute.model.entities.Category;
import com.lecaddyfute.model.entities.PromotedProduct;
import com.lecaddyfute.model.entities.Shop;
import com.lecaddyfute.model.entities.Users;
import com.lecaddyfute.service.DaoService;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Z
 */
@Service
public class AdminService extends DaoService {
    
    public List<Users> getUsers(){
        return this.getAll( "select u from Users u");
    }
    public List<Product> getProducts(){
        return this.getAll( "select p from Product p");
    }
    public List<Rayon> getRayons(){
        return this.getAll( "select r from Rayon r");
    }
    public List<Product> getShops(){
        return this.getAll( "select s from Shop s");
    }
    public List<Rayon> getRayonByName(String name){
        return this.getAll( "select r from Rayon r where r.name = '"+ name+"'");
    }
    public List<Category> getCategories(){
        return this.getAll( "select c from Category c");
    }
    public List<Category> getCategoryByName(String name){
        return this.getAll( "select c from Category c where c.name = '"+ name+"'");
    }
    public List<Shop> getShopByName(String name){
        return this.getAll( "select s from Shop s where s.name = '"+ name+"'");
    }
    public List<Shop> getShop(Shop shop){
        return this.getAll( "select s from Shop s where s.name = '"+ shop.getName()+"'"
                + "    and  s.address.street = '"+shop.getAddress().getStreet() +"' "
                + "    and  s.address.city = '"+shop.getAddress().getCity()+"' "
                + "    and  s.address.country = '"+shop.getAddress().getCountry()+"' ");
    }
    public List<Shop> getShopByAddress(Shop shop){
        return this.getAll( "select s from Shop s where  s.address.street = '"+shop.getAddress().getStreet() +"' "
                + "    and  s.address.city = '"+shop.getAddress().getCity()+"' "
              
               
              );
    
    }
    public List<PromotedProduct>getPromotedProducts(Shop shop){
        return this.getAll( "select p from PromotedProduct p where p.shop.id = '"+ shop.getId()+"'");
    }
}
