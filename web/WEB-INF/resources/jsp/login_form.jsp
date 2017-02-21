<%-- 
    Document   : login
    Created on : 31-Dec-2015, 16:20:44
    Author     : Z
--%>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

<li class="dropdown"><a class="dropdown-toggle header" data-toggle="dropdown" href="#"> <span class="glyphicon glyphicon-log-in header"></span><spring:message code="visitor.connect"/></a>
    <div class="dropdown-menu pull-right login">
        <form id="formLogin" class="form container-fluid login" 
              action="<spring:url value="/login" />"  modelattribute="user" method="post">

            <div>
                <div class="login form-group col-xs-4">
                    <label><spring:message code="label.username"/>:</label>
                    <spring:message code="label.username" var="username"/>
                    <form:input path="user.username"  class="form-control" 
                                            placeholder="${username}"/>
                </div>
                <div class="login form-group col-xs-4">
                    <label><spring:message code="label.password"/>:</label>
                    <spring:message code="label.password" var="password"/>
                    <form:input path="user.password"  class="form-control" 
                                            placeholder="${password}"/>
                </div>
                <div class="login form-group col-xs-4">
                <br/>
                <button type="submit" id="btnLogin" class="btn btn-block" 
                        style="margin-top:5px;"><spring:message code="visitor.connect"/></button>
                </div>
                <form:errors path="errorMessage" class="error"></form:errors>
            </div>
       
        </form>
        
        <div class="divider"></div>
        <div style="margin:10px 0px 10px 0px;">
        <form id="formSignUp" class="form container-fluid login" 
               action="<spring:url value="/signup" />"  method="get">
            <div class="col-xs-4 col-md-6">
                <a class="small" href="#"><spring:message code="label.forget.password"/></a>
            </div>
            <div class="col-xs-4 col-md-6">
                <button type="submit" id="btnSignUp" class="btn btn-block"><spring:message code="label.sign.up"/></button>
            </div>
        </form>
        </div> 	
    </div>
</li>
