<%-- 
    Document   : page-404
    Created on : Jul 11, 2014, 11:38:08 PM
    Author     : Nono Guy
--%>

<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

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
        <div id="menu-container">
        <div class="divs">        
            <div class="content homepage" id ="menu-8">
                <div class="container">
                    <%--<jsp:include page="submenus.jsp"/>--%>
                    <div class="row">

                        <div class="col-md-10 col-sm-10">
                            <h2><spring:message code="pageNotFound"/></h2>
                            <div class="col-sm-12">
                                <div class="error-page-wrapper">
                                    <p><spring:message code="page404Message1"/></p>
                                    <p><spring:message code="page404Message2"/> <a href="<c:url value="/home"/>">Home</a></p>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>                
                    </div>
                </div>    
            </div>    
           
        </div>
        <!-- Footer -->
        <jsp:include page="visitor_footer.jsp"/>
    </body>
</html>

