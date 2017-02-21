/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.service.security;


import com.lecaddyfute.model.entities.Users;
import com.lecaddyfute.service.DaoService;
import com.lecaddyfute.utils.DateUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 *
 * @author Nono
 */

@Service
public class UserDetailService extends DaoService implements UserDetailsService {
    @Autowired
        HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Users> leut = getAll("select u from User u where  u.username like  '" + username + "'");
        
        
//        Integer idAcountType = (Integer) RequestContextHolder.getRequestAttributes().getAttribute("accountType", RequestAttributes.SCOPE_REQUEST);
//        Integer idAcountType = (Integer)request.getAttribute("accountType");
//        int accountType = idAcountType;
        
        if (leut == null || leut.isEmpty()) {
            throw new UsernameNotFoundException("Username or Password incorrect");
        }
//        List<GrantedAuthority> auths = new ArrayList();
//        GrantedAuthority ga = new GrantedAuthority() {
//            @Override
//            public String getAuthority() {
//                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                // à implémenter
//                return "USER";
//            }
//        };
////        auths.add(ga);
//        auths = (List<GrantedAuthority>) getAuthorities(leut.get(0).getProfils());
//        org.springframework.security.core.userdetails.Users u = new org.springframework.security.core.userdetails.Users(username, leut.get(0).getPassword(), true, true, true, true, getAuthorities(leut.get(0).getProfils()));
//        return u;
    return null;
    }
    

    
    public static List<GrantedAuthority> getGrantedAuthorities(List<String> roles)
    {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for(String r : roles){
            authorities.add(new SimpleGrantedAuthority(r));
        }
        return authorities;
    }
    

}
