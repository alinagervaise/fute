
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="org.springframework.web.servlet.support.RequestContext"%> 
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>
<% String lang = (new RequestContext(request)).getLocale().getLanguage();%>
<%-- 
    Document   : visitor_header
    Created on : 15-Jan-2016, 12:31:58
    Author     : Z
--%>

<section id="header" class="row">
    <ul class="nav navbar">
         <li class="dropdown header">
            <a id="selected-lang" href="#" class="dropdown-toggle header" data-toggle="dropdown"
               aria-haspopup="true" aria-expanded="false"><div></div>
            </a> 
            <ul class="dropdown-menu pull-right language">
                <li <% if (lang.equalsIgnoreCase("fr")) { %> class="lang active selected" <%}%>
                    class="lang">
                    <a href="<spring:url value="?lang=fr"/>">
                        <div>
                        <img class="dropdown-menu-item language" 
                             src="<spring:url value="/resources/images/french-flag.PNG"/>" 
                             style="width:30px;height:20px;"/> 
                        <span class="dropdown-menu-item language" ><spring:message code="lang.fr"/></span>
                        </div>
                    </a>
                </li>
                <li class="divider"></li>
                <li <%if (lang.equalsIgnoreCase("en")) { %> class="lang active selected" <%}%>
                    class="lang">
                    <a href="<spring:url value="?lang=en"/>">
                        <div>
                            <img  class="dropdown-menu-item language" 
                                  src="<spring:url value="/resources/images/english-flag.PNG"/>"
                                  style="width:30px;height:20px;"/>
                            <span class="dropdown-menu-item language"><spring:message code="lang.en"/></span>
                        </div>
                    </a>
                </li>
            </ul>
        </li>
        <c:choose>
            <c:when test="${firstname != null }">
                <li class="dropdown header">
                    <a id="profil" href="#" class="dropdown-toggle header" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <span class="glyphicon glyphicon-user"></span> ${firstname}</a>
                        <div></div>
                    </a> 
                    <ul class="dropdown-menu pull-right profil-dropdown">
                   
                        <li><a href="<c:url value="/logout"/>" ><span class="glyphicon glyphicon-log-out"></span> 
                            <spring:message code="label.logout"/>
                            </a>
                        </li>
                    </ul>
                </li>
            </c:when> 
            <c:otherwise>
                 <jsp:include page="login.jsp"/>
            </c:otherwise>
        </c:choose>
        <li class="header"><a href="#" class="header"><spring:message code="liste"/>  <span class="badge">3</span></a></li>
        <li class="header"><a href="#" class="header"><spring:message code="visitor.position"/></a></li>   
    </ul>
</section>



<script src="<spring:url value="/resources/js/lecaddyfute-header.js"/>"></script>

    
