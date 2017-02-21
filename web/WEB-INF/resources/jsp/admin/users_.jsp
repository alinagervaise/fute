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
                    <h1 class="page-header"><spring:message code="label.user"/>s</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
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
                <th> <spring:message code="user.firstname"/></th>
                <th> <spring:message code="user.lastname"/></th>
                <th> <spring:message code="user.role"/></th>
                <th> <spring:message code="label.email"/></th>
                <th> <spring:message code="label.phone"/></th>
                <th> <spring:message code="label.password"/></th>
                <th><spring:message code="label.status"/></th>
                <th> <spring:message code="label.date.registration"/></th>
                <th> <spring:message code="label.date.activation"/></th>
                <th><spring:message code="label.edit"/></th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th> <spring:message code="user.id"/></th>
                <th> <spring:message code="user.firstname"/></th>
                <th> <spring:message code="user.lastname"/></th>
                <th> <spring:message code="user.role"/></th>
                <th> <spring:message code="label.email"/></th>
                <th> <spring:message code="label.phone"/></th>
                <th> <spring:message code="label.password"/></th>
                <th><spring:message code="label.status"/></th>
                <th> <spring:message code="label.date.registration"/></th>
                <th> <spring:message code="label.date.activation"/></th>
                <th><spring:message code="label.edit"/></th>
            </tr>
        </tfoot>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}          </td>
                    <td>${user.firstname}   </td>
                    <td>${user.lastname}    </td>
                    <td> <spring:message code="${user.role.label}" /></td>
                    <td>${user.email}       </td>
                    <td>${user.phone}       </td>
                    <td>${user.password}    </td>
                    <c:choose>
                        <c:when test="${user.isActive == '1'}">
                            <td> <spring:message code="label.active"/></td>
                        </c:when>
                        <c:otherwise>
                            <td> <spring:message code="label.desactivate"/></td>
                        </c:otherwise>
                    </c:choose>
                    <td>${user.dateCreation}</td>
                    <td>${user.dateActivation}</td>
                    <td>
                        <a class="fa fa-save" title="${modification}" href="/${user.id}?save"></a>
                        <a class="fa fa-cut" title="${totaldeletion}" href="/${user.id}?delete"></a>
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
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"</script>

    <!-- Metis Menu Plugin JavaScript -->
    <!--<script src="<spring:url value="/resources/js/admin/metisMenu.min.js"/>"</script>-->

    <!-- DataTables JavaScript -->
    <script src="<spring:url value="/resources/js/jquery.dataTables.min.js"/>"</script>
    <script src="<spring:url value="/resources/js/dataTables.bootstrap.min.js"/>"</script>
  
    <!-- Custom Theme JavaScript -->
    <!--<script src="<spring:url value="/resources/js/admin/sb-admin-2.js"/>"</script>-->

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