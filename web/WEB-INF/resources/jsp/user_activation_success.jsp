<%-- 
    Document   : user_activation_success
    Created on : 28-Feb-2016, 23:30:23
    Author     : Z
--%>

<%-- 
    Document   : connect_
    Created on : 06-Feb-2016, 22:48:44
    Author     : Z
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//FR"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
    <jsp:include page="head_.jsp"/>
    </head>
    <body class="container-fluid">
        <!-- Navigation -->
        <jsp:include page="visitor_header.jsp"/>
        <!-- search -->
        <jsp:include page="visitor_search.jsp"/>
        <!-- home -->
        <div class="container-fluid">
            <spring:message code="user.account.activate.success"/>
            <a href="<c:url value="/home"/>" > 
               <spring:message code="visitor.menu.home"/>
            </a>
        </div>
        <!-- Footer -->
        <section id="footer" class="row footer1">
            <div class="facebook" >    
                <a href="https://www.facebook.com/lecaddyfute" target="_blank">
                    <i class="fa fa-facebook fa-fw fa-2x"></i>
                </a>
            </div>
            <div class="copyright">
                <p class="text-muted">
                    Copyright &copy; <spring:message code="title.homepage"/> 2016
                </p>
            </div>
        </section>
    </body>
</html>
