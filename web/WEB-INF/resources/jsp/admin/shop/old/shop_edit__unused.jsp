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
                <h1 class="page-header">${shop.name}</h1>
            </div>
            <!-- /.col-lg-12 -->
        </div>

         <div class="row">
            <div class="col-xs-8" style="border-radius: 5px; border: 1px solid ; padding:10px;">
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
                <div class="col-xs-4" >
                   <a class="btn btn-default  btn-block"
                     data-toggle="modal" data-target="#addProductModal">
                      <spring:message code="label.add.product"/>
                   </a>
                </div>
            </div>
            <!-- Modal -->
                <div class="modal fade" id="addProductModal" role="dialog">
                    <div class="modal-dialog">
                        <!-- Modal content-->
                        <div class="modal-content">
                            <div class="modal-header">
                              <button type="button" class="close" data-dismiss="modal">&times;</button>
                              <h4 class="modal-title">Modal Header</h4>
                            </div>
                            <div class="modal-body">
                               <form class="form container-fluid product-add" 
                              action="<c:url  value="/admin/shop/products" />" modelattribute="promotedProduct"
                                  enctype="multipart/form-data" method="post">
                                <div class="row">

                                        <div class="form-group col-xs-6" >
                                            <label><spring:message code="label.name"/>:</label>
                                            <spring:message code="label.designation" var="designation"/>
                                            <spring:message code="label.designation.tooltip" var="designation-tooltip"/>
                                            <form:input path="promotedProduct.product.designation" class="form-control productDesignation" 
                                                        placeholder="${designation}" id="productDesignation"  
                                                     disabled="true"     data-toggle="tooltip" data-placement="bottom"/>
                                            <form:errors path="promotedProduct.product.designation" cssclass="error"></form:errors>
                                        </div>
                                        <div class="form-group col-xs-6" >
                                            <label><spring:message code="product.brand"/></label>
                                            <spring:message code="label.brand" var="brand"/>
                                            <spring:message code="label.brand.tooltip" var="brand-tooltip"/>
                                           <form:input path="promotedProduct.product.brand" class="form-control" 
                                                        placeholder="${brand}" disabled="true" name="product.brand"/>
                                            <form:errors path="promotedProduct.product.brand" cssclass="error"></form:errors>
                                        </div>
                                </div>
                                <div class="row" >

                                    <div class="form-group col-xs-6">
                                        <label><spring:message code="label.quantity"/>:</label>
                                        <spring:message code="label.quantity" var="quantity"/>
                                        <spring:message code="label.quantity.tooltip" var="quantity-tooltip"/>
                                        <form:input path="promotedProduct.product.quantity" class="form-control" 
                                                    placeholder="${quantity}"  disabled="true"/>
                                        <form:errors path="promotedProduct.product.quantity" cssclass="error"></form:errors>
                                    </div>

                                </div>
                                <div class="row" >
                                    <div class="form-group col-xs-6">
                                        <label><spring:message code="label.category"/></label>
                                        <spring:message code="label.category.tooltip" var="quantity-tooltip"/>
                                        <form:input path="promotedProduct.product.category.name" class="form-control" 
                                                    placeholder="${promotedProduct.product.category.name}" disabled="true" />
                                        <form:errors path="promotedProduct.product.quantity" cssclass="error"></form:errors>

                                    </div>
                                </div>
                                <div class="row" >
                                    <div class="form-group col-xs-12">
                                        <label><spring:message code="label.description"/></label>
                                        <spring:message code="label.description" var="description"/>
                                        <form:textarea path="promotedProduct.product.description"  class="form-control" 
                                                     rows="3"   placeholder="${description}" disabled="true"/>
                                        <form:errors path="promotedProduct.product.description" class="error"></form:errors>
                                    </div>
                                    <div class="form-group col-xs-12">
                                       <div class="form-group col-xs-6">
                                            <label><spring:message code="label.image"/></label>

                                        </div>
                                        <div class="form-group col-xs-6">

                                            <img id="img-product-id" src="${promotedProduct.product.mainImage}" width="100" height="100"/>
                                        </div>
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



                            <div class="modal-footer">
                               <a href="shop/delete?id=${shop.id}">
                                   <button  type="button"   class="btn btn-default" data-dismiss="modal">Yes</button>
                               </a>
                              <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                            </div>
                        </div>
                    </div>
                </div>
            <div class="col-xs-2">
               <a class="btn btn-default  btn-block"
                  href="<spring:url value="/admin/shop_product/edit" />">
                  <spring:message code="label.edit.shop"/>
               </a>
            </div>
         </div>
        <br/>
        <div class="row">
            <div class="col-lg-12">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        Promoted Products
                    </div>
    <!-- /.panel-heading -->
    <div class="panel-body">
        <div class="dataTable_wrapper dataTables_paginate">
            <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
    <thead>
        <tr>
            <th> <spring:message code="user.id"/></th>
            <th> <spring:message code="label.picture"/></th>
            <th> <spring:message code="label.designation"/></th>
            <th> <spring:message code="label.price"/></th>
            <th> <spring:message code="label.deal"/></th>
            <th> <spring:message code="label.quantity"/></th>
            <th> <spring:message code="label.date_creation"/></th>
            <th> <spring:message code="label.description"/></th>
            <th> <spring:message code="label.brand"/></th>
            <th> <spring:message code="label.action"/></th>
        </tr>
    </thead>
    <tfoot>
        <tr>
            <th> <spring:message code="user.id"/></th>
            <th> <spring:message code="label.picture"/></th>
            <th> <spring:message code="label.designation"/></th>
            <th> <spring:message code="label.price"/></th>
            <th> <spring:message code="label.deal"/></th>
            <th> <spring:message code="label.quantity"/></th>
            <th> <spring:message code="label.date_creation"/></th>
            <th> <spring:message code="label.description"/></th>
            <th> <spring:message code="label.brand"/></th>
            <th> <spring:message code="label.action"/></th>
        </tr>
    </tfoot>
    <tbody>
        <c:forEach items="${promotedProducts}" var="promotedProduct">
            <tr>
                <td>${promotedProduct.id}          </td>
                <td>
                    <img src="<spring:url value="/resources/${promotedProduct.product.mainImage}"/>" width="100"  height="100"/>
                </td>
                <td>${promotedProduct.product.designation}   </td>
                <td>${promotedProduct.price}          </td>
                <td>${promotedProduct.deal}          </td>
                <td>${promotedProduct.product.quantity}       </td>
                <td>${promotedProduct.product.description}   </td>
                 <td>${promotedProduct.product.brand}   </td>
                <td>${promotedProduct.dateCreation}    </td>
                <td>
                    <a class="fa fa-save" title="${modification}" href="admin/save?id=${promotedProduct.id}"></a>
                    <a  class="fa fa-cut" data-toggle="modal" data-target="#myModal"></a>
                     <a class="fa fa-eraser" title="${totaldeletion}"
                        href="product/delete?id=${promotedProduct.id}"></a>
                         <!-- Modal -->
          <div class="modal fade" id="myModal" role="dialog">
            <div class="modal-dialog">

              <!-- Modal content-->
              <div class="modal-content">
                <div class="modal-header">
                  <button type="button" class="close" data-dismiss="modal">&times;</button>
                  <h4 class="modal-title">Modal Header</h4>
                </div>
                <div class="modal-body">
                  <p>Do you really want to delete this item?</p>
                </div>
                <div class="modal-footer">
                   <a href="shop/product/save?id=${promotedProduct.id}">
                       <button  type="button"   class="btn btn-default" data-dismiss="modal">Yes</button>
                   </a>
                  <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                </div>
              </div>

            </div>
          </div>

                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>
                        </div>

                    </div>
                    <!-- /.panel-body -->
                </div>
                <!-- /.panel -->
            </div>
            <!-- /.col-lg-12 -->
        </div>

        <!-- /.row -->
                <!-- /.panel -->
            </div>
                <!-- /.col-lg-12 -->
        <!--    </div> -->
          
            <!-- /.row -->
     <!--   </div> -->

    
 <!-- jQuery -->
    <script src="<spring:url value="/resources/js/jquery-1.12.0.min.js" />"</script>

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
       
        
        $('#addProductModal').on('show.bs.modal', function (event) {
          var product = $("#selectedForm option:selected").text();
          var id = $("#selectedForm option:selected").val();
       
        $.ajax({

              type : "POST",
              contentType : "application/json",
              url: "product?id="+id,
              dataType: 'json', //json data type
              data: id,
              success:  function(data) { 
                        modal.find(".modal-body input#designation").val(data.designation);
                        modal.find(".modal-body input#description").val(data.description);
                        modal.find(".modal-body input#category").val(data.category);
                        modal.find(".modal-body input#brand").val(data.brand);
                        modal.find(".modal-body input#quantity").val(data.quantity);
                        modal.find(".modal-body input#img-product-id").attr("src", data.main_image);
                 }   
            });
          var button = $(event.relatedTarget) ;// Button that triggered the modal
          var modal = $(this);
          //modal.find('#productDesignation input').text(product);
        
          //modal.find('.modal-body input#productDesignation').val(product);
        
       
        });
    });
</script>