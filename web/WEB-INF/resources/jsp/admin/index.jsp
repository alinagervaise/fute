<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="/WEB-INF/c.tld" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="<spring:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<spring:url value="/resources/css/admin/metisMenu.min.css"/>" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="<spring:url value="/resources/css/admin/timeline.css"/>" rel="stylesheet">

    <!-- Custom CSS -->
    <%--<link href="<spring:url value="/resources/css/admin/sb-admin-2.css"/>" rel="stylesheet">--%>

    <!-- Morris Charts CSS -->
    <link href="<spring:url value="/resources/css/admin/morris.css"/>" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<spring:url value="/resources/css/font-awesome.min.css"/>" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
      
    <div id="wrapper">
         <!-- Navigation -->
         <%-- <jsp:include page="../visitor_header.jsp"/> --%>
        <!-- Navigation admin -->
        <jsp:include page="navigation.jsp"/>
        <!-- body-->
        <jsp:include page="body.jsp"/>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="<spring:url value="/resources/js/jquery.min.js"/>"</script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<spring:url value="/resources/js/bootstrap.min.js"/>"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<spring:url value="/resources/js/admin/metisMenu.min.js"/>"></script>

    <!-- Morris Charts JavaScript -->
    <script src="<spring:url value="/resources/js/admin/raphael-min.js"/>"></script>
    <script src="<spring:url value="/resources/js/admin/morris.min.js"/>"></script> 
    <script src="<spring:url value="/resources/js/admin/morris-data.js"/>"></script>
    

    <!-- Custom Theme JavaScript -->
    <script src="<spring:url value="/resources/js/admin/sb-admin-2.js"/>"></script>
    <%-- <script src="<spring:url value="/resources/js/lecaddyfute-header.js"/>"></script> --%>
</body>


