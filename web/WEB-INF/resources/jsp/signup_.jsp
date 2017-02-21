<%-- 
    Document   : connect
    Created on : 27-Jan-2016, 20:50:34
    Author     : Z
--%>

<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

<div class="container-fluid">
    <div class="row-fluid">
        <label><spring:message code="signup.title"/></label>
    </div>
    <div class="row-fluid">
        <div class="col-xs-6">
            <form id="formSign" class="form container-fluid signup" 
                  action="<spring:url value="/signup" />" modelattribute="user" method="post">
                <div class="row">
                    
                    <div>
                        <div class="form-group col-xs-6">
                            <label><spring:message code="label.firstname"/>:</label>
                            <spring:message code="label.firstname" var="firstname"/>
                            <spring:message code="input.firstname.tooltip" var="firstname-tooltip"/>
                            <form:input path="user.firstname"
                                        class="form-control" 
                                        placeholder="${firstname}" 
                                        />
                            <form:errors path="user.firstname" cssclass="error"></form:errors>
                        </div>
                        <div class="form-group col-xs-6">
                            <label><spring:message code="label.lastname"/></label>
                            <spring:message code="label.lastname" var="lastname"/>
                            <spring:message code="input.lastname.tooltip" var="lastname-tooltip"/>
                            <form:input path="user.lastname"  class="form-control" 
                                        placeholder="${lastname}"/>
                            <form:errors path="user.lastname" class="error"></form:errors>
                        </div>
                </div>
                <div classs="row">
                    <div class="form-group col-xs-12">
                        <label><spring:message code="label.username"/></label>
                        <spring:message code="label.username" var="username"/>
                        <form:input path="user.username"  class="form-control" 
                                        placeholder="${username}" />
                        <form:errors path="user.username" class="error"></form:errors>
                    </div>
                    <div class="form-group col-xs-12">
                        <label><spring:message code="label.email"/></label>
                        <spring:message code="label.email" var="email"/>
                        <spring:message code="input.email.tooltip" var="email-tooltip"/>
                        <form:input path="user.email"  class="form-control" 
                                        placeholder="${email}" />
                        <form:errors path="user.email" class="error"></form:errors>
                    </div>
                    <div class="form-group col-xs-12">
                        <label><spring:message code="label.phone"/></label>
                        <spring:message code="label.phone" var="phone"/>
                        <spring:message code="input.phone.tooltip" var="phone-tooltip"/>
                        <form:input path="user.phone"  class="form-control" 
                                        placeholder="${phone}" />
                        <form:errors path="user.phone" class="error"></form:errors>
                    </div>
                    <div class="form-group col-xs-12">
                        <label for="pwd"><spring:message code="label.password"/>:</label>
                        <spring:message code="label.password" var="password"/>
                        <spring:message code="input.password.tooltip" var="password-tooltip"/>
                        <form:password path="user.password"  class="form-control" 
                                        placeholder="${password}" />
                        <form:errors path="user.password" class="error"></form:errors>
                     
                    </div>
                    <div class="form-group col-xs-12">
                        <label for="pwd"><spring:message code="label.password.confirm"/>:</label>
                        <spring:message code="label.password.confirm" var="passwordConfirm"/>
                        <spring:message code="input.password.confirm.tooltip" var="password-confirm-tooltip"/>
                        <form:password path="user.passwordConfirmed"  class="form-control" 
                                        placeholder="${passwordConfirm}" />
                        <form:errors path="user.passwordConfirmed" class="error"></form:errors>
                    </div>
                    <div class="form-group col-xs-12">
                        <label class="radio-inline">
                           
                            <form:radiobutton path="user.role.id" value="2" 
                                              class="radio" checked="checked"/>
                            <spring:message code="label.customer"/>
                        </label>
                  
                        <label class="radio-inline">
                            <form:radiobutton path="user.role.id" value="3"
                                              class="radio" />
                            <spring:message code="label.company"/>
                        </label> 
                    </div>
                </div>
                <div class="row">
                    <div class="form-group col-xs-12">
                    
                    <button type="submit" id="btnLogin" class="btn btn-block" 
                            style="margin-top:5px;"><spring:message code="label.signup"/></button>
                    </div>
                </div>
                
            </div>
        </form>
        </div>
            
        <div class="col-xs-6">
            <img alt="" src="<spring:url value="/resources/images/lecaddy.PNG"/>"  width="100%"  height="100%">
        </div>
    </div>
</div>
  
<script>
    $(document).ready(function() {
        
        $(".radio").click(function (e){
            console.log("HERE"+!$(this).hasClass("checked"));
            console.log("HERE"+$(this).checked);
            console.log("HERE"+$(this).prop("checked"));
            console.log("HERE"+$(this).prop("checked") === "unchecked");
            if(!$(this).hasClass("checked")){
                $(".radio").not(this).each(function () {
                    $(this).removeAttr("checked");
                });
            }
        });
    });
</script>
