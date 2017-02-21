<%-- 
    Document   : visitor_header
    Created on : 29-Dec-2015, 14:46:41
    Author     : Z
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

 
<section id="home" class="row">
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner" role="listbox">
    <div class="item active">
      <img class="item-img" src="<spring:url value="/resources/images/supermarche.jpg"/>" 
           alt="<spring:message code="title.homepage"/>" style="width:100%; height:510px;">
      <div class="carousel-caption">
        <h3 style="color: #f59e00;"><b><spring:message code="title.homepage"/></b></h3>
        <p>
            Un service 100% gratuit et 100% indépendant qui
            permet de comparer de manière géolocalisée le prix des produits
            en supermarché et d'optimiser ainsi le pouvoir d’achat
            des consommateurs Ivoiriens.
        </p>
        <button id="button-join-facebook" 
                class="btn button-join-facebook" type="button">
            <spring:message code="button.join.facebook"/>
            <i class="fa fa-facebook fa-fw fa-2x"></i>
      </div>
    </div>

    <div class="item">
      <img class="item-img" src="<spring:url value="/resources/images/LogoCaddyFutté_MyriadPro.jpg"/>" 
           alt="Title 2" style="width:100%; height:510px;">
      <div class="carousel-caption">
        <h3 style="color: #f59e00;"><b>Title 2</b></h3>
        <p>Lorus Lorem </p>
        <button  id="button-join-facebook" 
                class="btn button-join-facebook" type="button">
            <spring:message code="button.join.facebook"/>
            <i class="fa fa-facebook fa-fw fa-2x"></i>
      </div>
    </div>

    <div class="item">
      <img class="item-img" src="<spring:url value="/resources/images/shampoo-compare.PNG"/>" 
           alt="Title 2" style="width:100%; height:510px;">
      <div class="carousel-caption">
        <h3 style="color: #f59e00;"><b>Title 2</b></h3>
        <p>Lorus Lorem </p>
        <button  id="button-join-facebook"
            class="btn button-join-facebook" type="button">
            <spring:message code="button.join.facebook"/>
            <i class="fa fa-facebook fa-fw fa-2x"></i>
      </div>
    </div>

</section>
<script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
