ct<%-- 
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
                    <h1 class="page-header"><spring:message code="label.product"/>s</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
         
            <br/>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            DataTables Advanced Tables
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <form class="form container-fluid product-add" 
                                  action="<c:url  value="/admin/products" />" modelattribute="product"
                                      enctype="multipart/form-data" method="post">
                                    <div class="row">

                                            <div class="form-group col-xs-6">
                                                <label><spring:message code="label.name"/>:</label>
                                                <spring:message code="label.designation" var="designation"/>
                                                <spring:message code="label.designation.tooltip" var="designation-tooltip"/>
                                                <form:input path="product.designation" class="form-control" 
                                                            placeholder="${designation}" />
                                                <form:errors path="product.designation" cssclass="error"></form:errors>
                                            </div>
                                            <div class="form-group col-xs-6">
                                                <label><spring:message code="product.brand"/></label>
                                                <spring:message code="label.brand" var="brand"/>
                                                <spring:message code="label.brand.tooltip" var="brand-tooltip"/>
                                               <form:input path="product.brand" class="form-control" 
                                                            placeholder="${brand}" />
                                                <form:errors path="product.brand" cssclass="error"></form:errors>
                                            </div>
                                    </div>
                                    <div class="row">

                                        <div class="form-group col-xs-6">
                                            <label><spring:message code="label.quantity"/>:</label>
                                            <spring:message code="label.quantity" var="quantity"/>
                                            <spring:message code="label.quantity.tooltip" var="quantity-tooltip"/>
                                            <form:input path="product.quantity" class="form-control" 
                                                        placeholder="${quantity}" />
                                            <form:errors path="product.quantity" cssclass="error"></form:errors>
                                        </div>
                                          
                                    </div>
                                    <div classs="row">
                                        <div class="form-group col-xs-6">
                                            <label><spring:message code="label.category"/>s</label>
                                           <form:select  path="product.category.name" class="form-control">
                                                <spring:message code="label.choose" var="choose"/>
                                                <form:option value="-" label="${choose}"/> 
                                                <c:forEach items="${categories}" var="category">
                                                    <form:option value="${category.name}">${category.name}</form:option>
                                                </c:forEach>
                                            </form:select>
                                            
                                        </div>
                                    </div>
                                    <div classs="row">
                                        <div class="form-group col-xs-12">
                                            <label><spring:message code="label.description"/></label>
                                            <spring:message code="label.description" var="description"/>
                                            <form:textarea path="product.description"  class="form-control" 
                                                         rows="3"   placeholder="${description}" />
                                            <form:errors path="product.description" class="error"></form:errors>
                                        </div>
                                        <div class="form-group col-xs-12">
                                           <div class="form-group col-xs-6">
                                                <label><spring:message code="label.image"/></label>
                                                <input type="file" id="input-file" name="fileUpload" size="100">
                                            </div>
                                            <div class="form-group col-xs-6">
                                               
                                                <img id="img-product-id" src="_" width="100" height="100"/>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="form-group col-xs-12">

                                        <button type="submit" id="btn-product-add" class="btn btn-block" 
                                                style="margin-top:5px;"><spring:message code="label.save"/></button>
                                        </div>
                                    </div>

                                </div>
                            </form>
                           
                            </div>
                       
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
          
            <!-- /.row -->
        </div>


  <!-- jQuery -->
    <script src="<spring:url value="/resources/js/jquery-1.12.0.min.js" />"</script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"</script>
    <%--<script src="<spring:url value="/resources/js/admin/metisMenu.min.js" />"</script>
  <script src="<spring:url value="/resources/js/admin/jquery-1.12.0.min.js" />"</script>--%>
   

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
        $(document).ready(function() {
            function readURL(input) {
                if (input.files && input.files[0]) {
                    var reader = new FileReader();

                    reader.onload = function (e) {
                        $('#img-product-id').attr('src', e.target.result);
                    };

                        reader.readAsDataURL(input.files[0]);
                    }
            }

            $("#input-file").change(function(){
                readURL(this);
            });
        });
    </script>