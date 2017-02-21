/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lecaddyfute.config;

import com.lecaddyfute.web.controller.exception.CustomHandlerExceptionResolver;
import java.util.List;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

/**
 *
 * @author Nono
 */
@Configuration
@EnableWebMvc
@ComponentScan("com.lecaddyfute.web")
public class WebConfig extends  WebMvcConfigurerAdapter{
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
      
       converters.add(new MappingJackson2HttpMessageConverter());
 
        super.configureMessageConverters(converters);
        
    }
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
	       CustomHandlerExceptionResolver  cher=new CustomHandlerExceptionResolver();
               exceptionResolvers.add(cher);
    }

    
      @Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/resources/");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		registry.addInterceptor(localeChangeInterceptor);
	}
        
        @Override
        public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
//          configurer
//                  .favorPathExtension(false).
//                    favorParameter(true).
//                    parameterName("mediaType")
//                  .ignoreAcceptHeader(true)
//                  .useJaf(false)
//                  .defaultContentType(MediaType.TEXT_HTML)
//                  .mediaType("xml", MediaType.APPLICATION_XML)
//                   .mediaType("json", MediaType.APPLICATION_JSON)
//                  ;
          configurer.favorPathExtension(false);
        }
        
       

       
            @Bean
        public UrlBasedViewResolver viewResolver() {
            UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
            viewResolver.setViewClass(JstlView.class);
            viewResolver.setPrefix("/WEB-INF/resources/jsp/");
            viewResolver.setSuffix(".jsp");
            
            return viewResolver;
        }
 
       
         @Bean
	public LocaleResolver localeResolver() {

		CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver();
		cookieLocaleResolver.setDefaultLocale(StringUtils.parseLocaleString("fr"));
		return cookieLocaleResolver;
	}
    
       
        @Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasenames("classpath:i18n/messages/messages");
		// if true, the key of the message will be displayed if the key is not
		// found, instead of throwing a NoSuchMessageException
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setDefaultEncoding("UTF-8");
		// # -1 : never reload, 0 always reload
		messageSource.setCacheSeconds(0);
		return messageSource;
	}
        
}
