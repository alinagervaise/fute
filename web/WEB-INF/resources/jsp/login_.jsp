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

<div class="container-fluid">
    <div class="row-fluid">
        <label class="col-xs-offset-4"><spring:message code="signin.title"/></label>
    </div>
    <div class="row-fluid">
    <form id="formLogin" class="form container-fluid login" 
          action="<spring:url value="/login" />"  modelattribute="user" method="post">

        <div class="row">
            <div class="login form-group col-xs-offset-4 col-xs-4">
                <label><spring:message code="label.username"/>:</label>
                <spring:message code="label.username" var="username"/>
                <form:input path="user.username"  class="form-control" 
                                        placeholder="${username}"/>
            </div>
        </div>
        <div class="row">
            <div class="login form-group col-xs-offset-4 col-xs-4">
                <label><spring:message code="label.password"/>:</label>
                <spring:message code="label.password" var="password"/>
                <form:password path="user.password"  class="form-control" 
                                        placeholder="${password}"/>
                 <form:errors path="user.password" class="error"></form:errors>
        </div>
            </div>
        </div>
        <div class="row">
            <div class="form-group col-xs-offset-4 col-xs-4">
           
            <button type="submit" id="btnLogin" class="btn btn-block" 
                    style="margin-top:5px;">
                <spring:message code="visitor.connect"/>
            </button>
            </div>
           

        </form>
    </div>

    <div class="divider"></div>
    <div style="margin:10px 0px 10px 0px;">
    <div class="row-fluid">
        <form id="formSignUp" class="form container-fluid login" 
               action="<spring:url value="/signup" />"  method="get">
            <div class="row">
                <div class=" col-xs-offset-4 col-xs-4 col-md-6">
                    <a class="small" href="#"><spring:message code="label.forget.password"/></a>
                </div>
            </div>
            <br/>
            <div class="row-fluid">
            <label class="col-xs-offset-4"><spring:message code="signup.invite.title"/></label>
            </div>
            <div class="row">
                <div class="col-xs-offset-4 col-xs-2">
                    <button type="submit" id="btnSignUp" class="btn btn-block"><spring:message code="label.sign.up"/></button>
                </div>
            </div>
        </form>
    </div>
</div>
