<%-- 
    Document   : users_
    Created on : 26-Mar-2016, 21:55:14
    Author     : Z
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
                    <h1 class="page-header"><spring:message code="label.category"/>s</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
             <div class="row">
                <div class="col-sm-offset-8 col-lg-4">
                   <a class="btn btn-default  btn-block"
                      href="<spring:url value="/admin/categories/add" />">
                      <spring:message code="label.add"/></a>
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
                            <div class="dataTable_wrapper dataTables_paginate">
                                <table id="example" class="table table-striped table-bordered" cellspacing="0" width="100%">
        <thead>
            <tr>
               <th> <spring:message code="user.id"/></th>
                <th> <spring:message code="label.name"/></th>
             
                <th> <spring:message code="label.description"/></th>
                <th> <spring:message code="label.picture"/></th>
                <th> <spring:message code="label.date_creation"/></th>
                <th> <spring:message code="label.action"/></th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th> <spring:message code="user.id"/></th>
                <th> <spring:message code="label.name"/></th>
                
                <th> <spring:message code="label.description"/></th>
                <th> <spring:message code="label.picture"/></th>
                <th> <spring:message code="label.date_creation"/></th>
                <th> <spring:message code="label.action"/></th>
              
            </tr>
        </tfoot>
        <tbody>
            <c:forEach items="${categories}" var="category">
                <tr>
                    <td>${category.id}          </td>
                    <td>${category.name}   </td>
                    <td>${category.description}       </td>
                    <td>
                        <img src="<spring:url value="/resources/${category.path}"/>" width="100"  height="100"/>
                    </td>
                    <td>${category.dateCreation}    </td>
                    <td>
                        <a class="fa fa-save" title="${modification}" href="admin/save?id=${category.id}"></a>
                        <a  class="fa fa-cut" data-toggle="modal" data-target="#myModal"></a>
                         <a class="fa fa-eraser" title="${totaldeletion}"
                            href="category/delete?id=${category.id}"></a>
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
                       <a href="category/delete?id=${category.id}">
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
        </div>


  <!-- jQuery -->
    <script src="<spring:url value="/resources/js/jquery-1.12.0.min.js" />"</script>

    <!-- Bootstrap Core JavaScript -->
     <script src="<spring:url value="/resources/js/bootstrap.js"/>"</script>
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"</script>

    <!-- Metis Menu Plugin JavaScript -->
    <%--<script src="<spring:url value="/resources/js/admin/metisMenu.min.js"/>"</script>--%>

    <!-- DataTables JavaScript -->
    <script src="<spring:url value="/resources/js/jquery.dataTables.min.js"/>"</script>
    <script src="<spring:url value="/resources/js/dataTables.bootstrap.min.js"/>"</script>
  
    <!-- Custom Theme JavaScript -->
    <%--<script src="<spring:url value="/resources/js/admin/sb-admin-2.js"/>"</script>--%>

    <!-- Page-Level Demo Scripts - Tables - Use for reference -->
    <script>
    $(document).ready(function() {
        $('#example').DataTable(
            {
               
               'aoColumnDefs': [{
                    'bSortable': false,
                    'aTargets': [-1, -3] /* 1st one, start by the right */
                }]
            }
        );
    });
    </script>