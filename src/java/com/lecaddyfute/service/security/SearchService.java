/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.service.security;


import com.lecaddyfute.model.entities.City;
import com.lecaddyfute.model.entities.Neighborhood;
import com.lecaddyfute.service.DaoService;
import java.util.List;

import org.springframework.stereotype.Service;

/**
 *
 * @author Z
 */
@Service
public class SearchService extends DaoService {
    
    public List<City> getCity(int zipCode){
        return this.getAll( "select c from City c where c.zipCode like '"
                    +zipCode+"%'");
    }
    public List<City> getCity(String name){
        return this.getAll( "select c from City c where c.name like '"
                    + name  + "%'"
                    );
    }
    public List<Neighborhood> getNeighborhood(String name){
        return this.getAll( "select n from Neighborhood n where n.name like '"
                    + name + "%'");
    }
    public List<Neighborhood> getLocation(String name){
         return this.getAll( "select n from City c ,  Neighborhood n where c.name like '"
                    + name  + "%'"
                    + " or n.name like '"+name + "%'"
                   // + " and n.city = c"
                    );
    }
}
