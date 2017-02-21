/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.lecaddyfute.web.init;

import com.lecaddyfute.web.controller.exception.BusinessException;
import com.lecaddyfute.web.controller.exception.PageNotFoundException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.UrlPathHelper;

/**
 *
 * @author 
 */
public class CustomDispatcherServlet   extends  DispatcherServlet{
    
    private static final UrlPathHelper urlPathHelper = new UrlPathHelper();

    CustomDispatcherServlet(WebApplicationContext servletAppContext) {
        super(servletAppContext);
    }

    public CustomDispatcherServlet() {
        super();
    }
    
    @Override
    protected void noHandlerFound(HttpServletRequest request, HttpServletResponse response) throws Exception {
	   String requestUri = urlPathHelper.getRequestUri(request);	
             if (pageNotFoundLogger.isWarnEnabled()) {
			pageNotFoundLogger.warn("No mapping found for HTTP request with URI [" + requestUri +
					"] in DispatcherServlet with name '" + getServletName() + "'");
		}
		//response.sendError(HttpServletResponse.SC_NOT_FOUND);
                throw  new PageNotFoundException("No mapping found for HTTP request with URI [" + requestUri +
					"] in DispatcherServlet with name '" + getServletName() + "'");
	}
    
}
