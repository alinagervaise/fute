<%-- 
    Document   : head
    Created on : 06-Feb-2016, 22:08:03
    Author     : Z
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--logo -->
<link rel="icon" href="<spring:url value="/resources/images/lecaddy.PNG"/>" type="image/x-icon" />
<link rel="shortcut icon" href="<spring:url value="/resources/images/lecaddy.PNG"/>" type="image/x-icon" />

<!DOCTYPE html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title><spring:message code="title.homepage"/></title>
<jsp:include page="resources.jsp"/>
</head>