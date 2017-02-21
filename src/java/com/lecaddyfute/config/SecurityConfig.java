/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecaddyfute.config;

import com.lecaddyfute.utils.StringUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.ExceptionMappingAuthenticationFailureHandler;

/**
 *
 * @author Nono
 */
@Configuration
@EnableWebMvcSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/signup**").permitAll()         
                .antMatchers("/resources/**", "/signup", "/connect", "/about").permitAll()
                .antMatchers("/admin").authenticated()
                .antMatchers("/update").authenticated()
//                .anyRequest().authenticated()                
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/home?message=Logout Successfully")
                .invalidateHttpSession(true)
                .and()
                .portMapper().http(8080).mapsTo(8443)
                .and()
                .requiresChannel()
                .anyRequest().requiresInsecure()
                .and()
                .csrf().disable()        
                .sessionManagement()
                .maximumSessions(1).expiredUrl("/login?message=Session Expirée par une autre connexion")
                //.maxSessionsPreventsLogin(true)
                ;
    }

    @Autowired
    private UserDetailsService uds;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(uds);
        //.passwordEncoder(passwordEncoder());

    }

    @Override
    public void configure(WebSecurity builder) throws Exception {
        builder.ignoring()
                .antMatchers("/resources/**", "/resources");
    }

    @Bean
    public ShaPasswordEncoder passwordEncoder() throws Exception {
        return new ShaPasswordEncoder();
    }
    
    @Autowired
    public AuthenticationFailureHandler authenticationFailureHandler() throws Exception {
        ExceptionMappingAuthenticationFailureHandler authenticationFailureHandler = new ExceptionMappingAuthenticationFailureHandler();
        authenticationFailureHandler.setDefaultFailureUrl("/login");
        return authenticationFailureHandler;
    }

    @Autowired
    public AuthenticationSuccessHandler authenticationSuccessHandler() throws Exception {
        AuthenticationSuccessHandler authenticationSuccessHandler = new AuthenticationSuccessHandler() {

            @Override
            public void onAuthenticationSuccess(HttpServletRequest hsr,
                    HttpServletResponse hsr1, Authentication a)
                    throws IOException, ServletException {

                String url = hsr.getContextPath() + "/authenticationSuccess";
                System.setProperty("spring.security.disableUISecurity", "true");
                hsr1.sendRedirect(url);
            }
        };
        return authenticationSuccessHandler;
    }

}
