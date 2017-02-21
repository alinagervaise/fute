<%-- 
    Document   : visitor_navigation
    Created on : 29-Dec-2015, 14:12:35
    Author     : Z
--%>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


    <nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>                        
          </button>
          <a class="navbar-brand" href="index">Logo</a>
        </div>
    
        <div class="collapse navbar-collapse" id="#navBar">
          <ul class="nav navbar-nav navbar-right" id="#sub-navbar">
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span><spring:message code="visitor.menu.connect"/></a></li>
          </ul>
       
        
        </div>
      </div>
    </nav>

