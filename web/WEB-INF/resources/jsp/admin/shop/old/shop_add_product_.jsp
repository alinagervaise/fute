<%-- 
    Document   : users_
    Created on : 26-Mar-2016, 21:55:14
    Author     : Z
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="/WEB-INF/c.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="Gervaise ALina" content="">

    <title><spring:message code="title.homepage"/></title>

    <!-- Bootstrap Core CSS -->
    <link src="<spring:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- DataTables CSS -->
    <link src="<spring:url value="/resources/css/admin/dataTables.bootstrap.min.css"/>" 
    rel="stylesheet">
   
    <!-- Custom Fonts -->
    <link src="<spring:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">


</head>
<!DOCTYPE html>
<div id="page-wrapper">
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header"><spring:message code="label.add.product"/></h1>
        </div>
        <!-- /.col-lg-12 -->
    </div>
    <div class="row">
        <div class="panel panel-default">
            <div class="panel-heading">
                Promoted Products
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <div class="row">
                    <div class="col-xs-6">
                        <form:select  path="promotedProduct.product.designation" class="form-control"
                                      id="selectedForm">
                            <spring:message code="label.choose" var="choose"/>
                            <form:option value="-" label="${choose}"/> 
                            <c:forEach items="${products}" var="product">
                                <form:option value="${product.id}">${product.designation}</form:option>
                            </c:forEach>
                        </form:select>
                    </div>      
                    <div class="form-group col-xs-6">
                        <img id="img-product-id" src="${promotedProduct.product.mainImage}" width="100" height="100"/>
                    </div>     
                </div>
                <div class="row">
                    <form   class="form container-fluid product-add" 
                            action="<c:url  value="/admin/shop/products"/>"
                            modelattribute="promotedProduct"
                            enctype="multipart/form-data" method="post">
                        <div class="row">
                            <div class="form-group col-xs-6" >
                                <label><spring:message code="label.name"/>:</label>
                                <spring:message code="label.designation" var="designation"/>
                                <spring:message code="label.designation.tooltip" var="designation-tooltip"/>
                                <form:input path="promotedProduct.product.designation" class="form-control productDesignation" 
                                            placeholder="${designation}" id="designation"  
                                         disabled="true"     data-toggle="tooltip" data-placement="bottom"/>
                                <form:errors path="promotedProduct.product.designation" cssclass="error"></form:errors>
                            </div>
                            <div class="form-group col-xs-6" >
                                <label><spring:message code="label.price"/>:</label>
                                <spring:message code="label.price" var="price"/>
                                <spring:message code="label.price.tooltip" var="price-tooltip"/>
                                <form:input path="promotedProduct.price" class="form-control" 
                                            placeholder="${price}" id="price"  
                                           data-toggle="tooltip" data-placement="bottom"/>
                                <form:errors path="promotedProduct.price" cssclass="error"></form:errors>
                            </div>
                        </div>
                        <div class="row" >
                            <div class="form-group col-xs-6" >
                                <label><spring:message code="product.brand"/></label>
                                <spring:message code="label.brand" var="brand"/>
                                <spring:message code="label.brand.tooltip" var="brand-tooltip"/>
                               <form:input path="promotedProduct.product.brand" class="form-control" 
                                            placeholder="${brand}" disabled="true" id="brand"/>
                                <form:errors path="promotedProduct.product.brand" cssclass="error"></form:errors>
                            </div>
                            <div class="form-group col-xs-6" >
                                <label><spring:message code="label.deal"/>:</label>
                                <spring:message code="label.deal" var="deal"/>
                                <spring:message code="label.deal.tooltip" var="deal-tooltip"/>
                                <form:input path="promotedProduct.deal" class="form-control" 
                                            placeholder="${deal}" id="deal"  
                                           data-toggle="tooltip" data-placement="bottom"/>
                                <form:errors path="promotedProduct.deal" cssclass="error"></form:errors>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-xs-6">
                                <label><spring:message code="label.category"/></label>
                                <spring:message code="label.category" var="category"/>
                                <spring:message code="label.category.tooltip" var="quantity-tooltip"/>
                                <form:input path="promotedProduct.product.category.name" class="form-control" 
                                            id="category" placeholder="${category}" disabled="true" />
                                <form:errors path="promotedProduct.product.category.name" cssclass="error"></form:errors>
                            </div>
                            <div class="form-group col-xs-6">
                                <label><spring:message code="label.quantity"/>:</label>
                                <spring:message code="label.quantity" var="quantity"/>
                                <spring:message code="label.quantity.tooltip" var="quantity-tooltip"/>
                                <form:input path="promotedProduct.product.quantity" class="form-control" 
                                     id="quantity"       placeholder="${quantity}"  disabled="true"/>
                                <form:errors path="promotedProduct.product.quantity" cssclass="error"></form:errors>
                            </div>
                        </div>
                        <div class="row" >
                            <div class="form-group col-xs-12">
                                <label><spring:message code="label.description"/></label>
                                <spring:message code="label.description" var="description"/>
                                <form:textarea path="promotedProduct.product.description"  class="form-control" 
                                           id="description"  rows="3"   placeholder="${description}" disabled="true"/>
                                <form:errors path="promotedProduct.product.description" class="error"></form:errors>
                            </div>
                        </div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" id="btn-product-add" class="btn btn-block" 
                                        style="margin-top:5px;"><spring:message code="label.save"/></button>
                            </div>
                        </div>
                    </form>
                </div>
               
            </div>
        </div>
    </div>                
</div>
          

    
 <!-- jQuery -->
    <script src="<spring:url value="/resources/js/jquery-1.12.0.min.js" />"></script>

    <!-- Bootstrap Core JavaScript -->
     <script src="<spring:url value="/resources/js/bootstrap.js"/>"></script>
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>
    <%--<script src="<spring:url value="/resources/js/admin/metisMenu.min.js" />"</script>
  <script src="<spring:url value="/resources/js/admin/jquery-1.12.0.min.js" />"</script>--%>
   

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
<script>
    var contexPath = "<%=request.getContextPath() %>";
   
    $(document).ready(function() {
        $('[data-toggle="tooltip"]').tooltip();
       
       
        $('select').on( "change",function () {
       
            var id = $("#selectedForm option:selected").val();
            $.ajax({

              type : "POST",
              contentType : "application/json",
              url: "product?id="+id,
              dataType: 'json', //json data type
              data: id,
              success:  function(data) { 
                        $("#designation").val(data.designation);
                        $("#description").val(data.description);
                        $("#category").text(data.category);
                        $("#brand").val(data.brand);
                        $("#quantity").val(data.quantity);
                        $("#img-product-id").attr("src", data.main_image);
                 }   
            });
         });
    });
</script>