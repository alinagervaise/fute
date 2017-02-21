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
        <c:choose>
            <c:when test="${type_account == 2 }">
                <jsp:include page="customer/signup_confirmation_customer_.jsp"/>
            </c:when> 
            <c:otherwise>
                <jsp:include page="business/signup_confirmation_business_.jsp"/>
            </c:otherwise>
        </c:choose>
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
