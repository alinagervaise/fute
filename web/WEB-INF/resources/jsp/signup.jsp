
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//FR"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
  
    <head>
        <link href="<spring:url value="/resources/css/lecaddyfute-style.css"/>" rel="stylesheet" type="text/css"/>
        <jsp:include page="head_.jsp"/>
    </head>
    
    <body class="container-fluid">
        <!-- Navigation -->
        <jsp:include page="visitor_header.jsp"/>
        <!-- search -->
        <jsp:include page="visitor_search.jsp"/>
       
        <jsp:include page="signup_.jsp"/>
        <!-- Footer -->
        <jsp:include page="visitor_footer.jsp"/>
    </body>
</html>
