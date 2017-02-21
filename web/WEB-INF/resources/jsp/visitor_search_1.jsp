<%-- 
    Document   : visitor_search
    Created on : 15-Jan-2016, 12:35:59
    Author     : Z
--%>
<%@taglib  uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="/WEB-INF/c.tld" prefix="c"%>

<section id="search" class="row">
    <div class="favicon">
        <a href="<c:url value="/home"/>">
            <img  src="<spring:url value="/resources/images/favicon.png"/>"/>
        </a>
    </div>
    <div class="col-md-6">
     <form id="form-search">
        <div class="form-group input-group">
            <div id="div-category" class="input-group-btn">
                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categories <span class="caret"></span></button>
                <ul class="multi-dropdown-menu dropdown-menu multi-column columns-3">
                        <div class="row">
                                <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li><a href="#">Action</a></li>
                                            <li><a href="#">Another action</a></li>
                                            <li><a href="#">Something else here</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">One more separated link</a></li>
                                        </ul>
                                </div>
                                <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li><a href="#">Action</a></li>
                                            <li><a href="#">Another action</a></li>
                                            <li><a href="#">Something else here</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">One more separated link</a></li>
                                        </ul>
                                </div>
                                <div class="col-sm-4">
                                        <ul class="multi-column-dropdown">
                                            <li><a href="#">Action</a></li>
                                            <li><a href="#">Another action</a></li>
                                            <li><a href="#">Something else here</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">Separated link</a></li>
                                            <li class="divider"></li>
                                            <li><a href="#">One more separated link</a></li>
                                        </ul>
                                </div>
                        </div>
                </ul>
            </div>
            <input type="text" class="form-control">
            <span id="span-button-search" class="input-group-btn">
                <button id="button-search" class="btn btn-default" type="button">
                    <spring:message code="search"/> 
                    <i class="glyphicon glyphicon-search"></i>
                </button>
            </span>
        </div>
    </form>
    </div>
   <!-- <div class="nav-button">
        <ul class="nav nav-pills">
        </ul>
    </div>-->
</section>
   